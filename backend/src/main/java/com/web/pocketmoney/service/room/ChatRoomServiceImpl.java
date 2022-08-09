package com.web.pocketmoney.service.room;

import com.web.pocketmoney.dto.chatRoom.ChatRoomDetailDto;
import com.web.pocketmoney.dto.chatRoom.ChatRoomSaveDto;
import com.web.pocketmoney.dto.message.MessageDetailDto;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.message.MessageRepository;
import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.room.ChatRoomRepository;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.exception.CUserNotFoundException;
import com.web.pocketmoney.exception.ChatRoomNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository crr;
    private final MessageRepository cr;

    private final UserRepository userRepository;

    //채팅방 전체보기
    @Override
    public List<ChatRoomDetailDto> findAllRooms(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CUserNotFoundException(
                        "존재하지 않는 유저입니다."
                ));

        List<ChatRoom> chatRoomEntityList = crr.findAllByEmployeeOrEmployer(Sort.by(Sort.Direction.DESC, "id"), user);
//        List<ChatRoomDetailDto> chatRoomList = new ArrayList<>();
//
//        for(ChatRoom c : chatRoomEntityList){
//            chatRoomList.add(ChatRoomDetailDto.toChatRoomDetailDto(c));
//        }
//        return chatRoomList;
        return chatRoomEntityList.stream().map(chatRoomDetailDto -> entityToDto(chatRoomDetailDto)).collect(Collectors.toList());
    }

    //채팅방 id로 채팅방 찾기
    @Override
    public ChatRoomDetailDto findRoomById(Long id) {
        ChatRoom chatRoom = crr.findById(id)
                .orElseThrow(() -> new ChatRoomNotFoundException(
                        "채팅방을 찾을 수 없습니다."
                ));
        List<Object[]> result = crr.findByUserIdWithMessages(chatRoom);
        log.info("result : "+ result);
        ChatRoom chatRoom1 = (ChatRoom) result.get(0)[0];
        log.info("get(0)[0] : "+ chatRoom1);

        List<Message> messages = new ArrayList<>();

        result.forEach(arr -> {
            Message message = (Message) arr[1];
            messages.add(message);
        });
        return entitiesToDetailDto(chatRoom1, messages);
    }

    @Override
    public void createRoom(ChatRoomSaveDto chatRoomSaveDto) {
        ChatRoom chatRoom = chatRoomSaveDtoToEntity(chatRoomSaveDto);
        crr.save(chatRoom);
    }

    @Override
    public void deleteById(Long chatRoomId) {
        log.info("chatROomId : " +chatRoomId);
        crr.deleteById(chatRoomId);
    }

//    @Override
//    public List<MessageDetailDto> findAllChatByRoomId(Long id) {
//        List<Message> messageEntityList = cr.findAllByChatRoom_RoomId(roomId);
//        List<MessageDetailDto> messageList = new ArrayList<>();
//
//        for(Message m : messageEntityList){
//            messageList.add(MessageDetailDto.toChatMessageDetailDto(m));
//        }
//        return messageList;
//    }
}
