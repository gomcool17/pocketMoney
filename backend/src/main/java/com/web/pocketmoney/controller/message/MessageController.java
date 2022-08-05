package com.web.pocketmoney.controller.message;

import com.web.pocketmoney.dto.message.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

//채팅을 보내는 행위는 Publisher의 행위로 간주한다. 이 때 보내는 채팅의 채팅방은 클라이언트 자신이
//Subscribe하고 있는 Topic이며 해당방을 Sub하고 있는 모든 Subscriber에게 보내줘야 한다.
@RestController
@RequiredArgsConstructor
public class MessageController {

//    private final MessageService messageService;
//
//    @PostMapping
//    public ChatRoom createRoom(@RequestParam String name){
//        return messageService.createRoom(name);
//    }
//
//    @GetMapping
//    public List<ChatRoom> findAllRoom(){
//        return messageService.findAllRoom();
//    }

    private final SimpMessageSendingOperations sendingOperations;

    //@MessageMapping을 선언해서 WebSocket으로 들어오는 메시지 발행을 처리한다.
    //클라이언트는 prefix를 붙여서 [/pub/comm/message]로 발행을 요청하면
    //메시지가 발행되면 [/sub/comm/message/{roomId}]로 메시지를 send하게 되는데
    //클라이언트에서는 해당 주소를 Subscribe(구독)하고 있다가 메시지가 전달되면 화면에 출력한다.
    @MessageMapping("/comm/message")
    public void message(MessageDto message){
        if(MessageDto.MessageType.ENTER.equals(message.getMessageType())){
            message.setMessage(message.getSender() + "이 입장했습니다.");
        }
        sendingOperations.convertAndSend("/sub/comm/room/" + message.getRoomId(), message);
        //[sub/comm/room/{roomId}]가 sub주소이다.
    }


}