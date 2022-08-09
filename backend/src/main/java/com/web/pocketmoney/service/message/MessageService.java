package com.web.pocketmoney.service.message;

import com.web.pocketmoney.dto.message.MessageDetailDto;
import com.web.pocketmoney.dto.message.MessageSaveDto;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.room.ChatRoom;

import java.util.List;

public interface MessageService {

    List<MessageDetailDto> findAllChatByRoomId(Long id);

    void save(MessageSaveDto messageSaveDto);

    default MessageDetailDto entityToDto(Message message){
        MessageDetailDto messageDetailDto = MessageDetailDto.builder()
                .messageId(message.getId())
                .chatRoomId(message.getChatRoom().getId())
                .roomName(message.getChatRoom().getRoomName())
                .writer(message.getWriterNickName())
                .message(message.getMessage())
                .build();
        return messageDetailDto;
    }

    default Message dtoToEntity(MessageSaveDto messageSaveDto){
        Message message = Message.builder()
                .chatRoom(ChatRoom.builder().id(messageSaveDto.getRoomid()).build())
                .writerNickName(messageSaveDto.getWriter())
                .message(messageSaveDto.getMessage())
                .build();
        return message;
    }

}
