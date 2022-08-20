package com.web.pocketmoney.controller.message;

import com.web.pocketmoney.dto.message.MessageDetailDto;
import com.web.pocketmoney.dto.message.MessageSaveDto;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.message.MessageRepository;
import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.room.ChatRoomRepository;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.service.message.MessageService;
import com.web.pocketmoney.service.room.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StompChatController {

    private final SimpMessagingTemplate template; //특정 Broker로 메세지를 전달
    private final MessageRepository messageRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomService chatRoomService;
    private final MessageService messageService;

    //Client가 Send할 수 있는 경로
    //WebSocketConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    //"/pub/chat/enter" --> enter이므로 처음 접속할때는 이 경로로 메시지를 뿌려준다. 즉 입장 메세지
    @MessageMapping(value = "/chat/enter") //발행하는 경로, /chat/enter라는 경로로 메세지를 보내면 구독자들에게 메세지를 뿌린다.
    public void enter(MessageSaveDto message, @AuthenticationPrincipal User user){
        message.setMessage(message.getWriter() + "님이 채팅방에 입장하였습니다.");

        List<MessageDetailDto> chatList = messageService.findAllChatByRoomId(message.getRoomId(), user.getId());
//        if(chatList != null){
//            for(MessageDetailDto m : chatList){
//                message.setWriter(m.getWriter());
//                message.setMessage(m.getMessage());
//            }
//        }

        //convertAndSend()는 Object타입 객체를 인자로 받아 내부적으로 Message타입으로 변환한다.
        template.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);

//        ChatRoom chatRoom =  chatRoomService.findRoomById(message.getChatRoomId());
        MessageSaveDto messageSaveDto = MessageSaveDto.builder()
                .roomId(message.getRoomId())
                .writer(message.getWriter())
                .message(message.getMessage())
                .build();
        messageService.save(messageSaveDto);
    }

    //pub으로 메시지 받음
    @MessageMapping(value = "/chat/message")
    public void message(MessageSaveDto message, @AuthenticationPrincipal User user){
        //뷰에서 subscribe(path, callback)으로 메세지를 받을 수 있음
        //room.html에서 stomp.subscribe("/sub/chat/room/" + roomId, function(chat) { 부분에 message가 chat으로 넘어감
        //pub으로 MessageMapping을 통해 메시지를 받은 후, sub으로 뿌려주고 DB에 저장하는 로직

        //DB에 채팅내용 저장
        MessageSaveDto messageSaveDto = MessageSaveDto.builder()
                .roomId(message.getRoomId())
                .writer(message.getWriter())
                .message(message.getMessage())
                .build();
        Long messageId = messageService.save(messageSaveDto);

        MessageDetailDto messageDetailDto = messageService.findOne(messageId, user.getId());

        template.convertAndSend("/sub/chat/room" + message.getRoomId(), messageDetailDto);
    }
    //@MessageMapping을 통해 WebSocket으로 들어오는 메시지 발행을 처리한다. pub이 앞에 붙어 메시지를 전송한다는 뜻
    //MessageDetailDto형태로 받은 message안에는 roomId가 있으므로 어떤 채팅방에 뿌릴지 정해진다.
    //convertAndSend를 통해 roomId를 sub uri에 더해서 메시지를 전해주면, 그 방을 구독한 사용자들에게 뿌려준다.
    //기존의 핸들러 ChatHandler의 역할을 대신 해주므로 핸들러는 없어도 된다.

}