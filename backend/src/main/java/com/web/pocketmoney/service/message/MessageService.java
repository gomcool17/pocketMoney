package com.web.pocketmoney.service.message;

import com.web.pocketmoney.dto.message.MessageDetailDto;
import com.web.pocketmoney.dto.message.MessageSaveDto;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.room.ChatRoom;

import java.util.List;
import java.util.stream.Collectors;

public interface MessageService {

    List<MessageDetailDto> findAllChatByRoomId(Long id, Long userId);

    Long save(MessageSaveDto messageSaveDto);

    MessageDetailDto findOne(Long messageId, Long userId);

    default Message dtoToEntity(MessageSaveDto messageSaveDto){
        Message message = Message.builder()
                .chatRoom(ChatRoom.builder().id(messageSaveDto.getRoomId()).build())
                .writerNickName(messageSaveDto.getWriter())
                .message(messageSaveDto.getMessage())
                .build();
        return message;
    }

}
