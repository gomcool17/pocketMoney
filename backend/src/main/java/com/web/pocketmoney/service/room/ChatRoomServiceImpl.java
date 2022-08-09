package com.web.pocketmoney.service.room;

import com.web.pocketmoney.dto.chatRoom.ChatRoomDetailDto;
import com.web.pocketmoney.dto.chatRoom.ChatRoomSaveDto;
import com.web.pocketmoney.dto.message.MessageDetailDto;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.message.MessageRepository;
import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.room.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository crr;
    private final MessageRepository cr;

    //채팅방 전체보기
    @Override
    public List<ChatRoomDetailDto> findAllRooms() {
        List<ChatRoom> chatRoomEntityList = crr.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<ChatRoomDetailDto> chatRoomList = new ArrayList<>();

        for(ChatRoom c : chatRoomEntityList){
            chatRoomList.add(ChatRoomDetailDto.toChatRoomDetailDto(c));
        }
        return chatRoomList;
    }

    //채팅방 id로 채팅방 찾기
    @Override
    public ChatRoomDetailDto findRoomById(String roomId) {
        ChatRoom chatRoom = crr.findByRoomId(roomId);
        ChatRoomDetailDto chatRoomDetailDto = ChatRoomDetailDto.toChatRoomDetailDto(chatRoom);
        return chatRoomDetailDto;
    }

    @Override
    public void createChatRoomDto(String name, int password, String chatMentor) {
        ChatRoomSaveDto roomSaveDto = ChatRoomSaveDto.create(name);
                ChatRoom chatRoom = ChatRoom.toChatRoomEntity(roomSaveDto.getName(), password, roomSaveDto.getRoomId(), chatMentor);
                crr.save(chatRoom);
    }

    @Override
    public void deleteById(Long chatRoomId) {
        log.info("chatROomId : " +chatRoomId);
        crr.deleteById(chatRoomId);
    }

    @Override
    public List<MessageDetailDto> findAllChatByRoomId(String roomId) {
        List<Message> messageEntityList = cr.findAllByChatRoom_RoomId(roomId);
        List<MessageDetailDto> messageList = new ArrayList<>();

        for(Message m : messageEntityList){
            messageList.add(MessageDetailDto.toChatMessageDetailDto(m));
        }
        return messageList;
    }
}
