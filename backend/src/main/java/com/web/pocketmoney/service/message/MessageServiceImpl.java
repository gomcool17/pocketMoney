package com.web.pocketmoney.service.message;

import com.web.pocketmoney.dto.message.MessageDetailDto;
import com.web.pocketmoney.dto.message.MessageSaveDto;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.message.MessageRepository;
import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.room.ChatRoomRepository;
import com.web.pocketmoney.exception.ChatRoomNotFoundException;
import com.web.pocketmoney.exception.handler.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Log4j2
public class MessageServiceImpl implements MessageService{

    private final ChatRoomRepository chatRoomRepository;
    private final MessageRepository messageRepository;

    @Override
    public List<MessageDetailDto> findAllChatByRoomId(Long id) {

        ChatRoom chatRoom =  chatRoomRepository.findById(id)
                .orElseThrow(() -> new ChatRoomNotFoundException(
                        "찾는 방이 없습니다.", ErrorCode.FORBIDDEN
                ));

        List<Message> result = messageRepository.findAllByChatRoom_RoomId(chatRoom.getId());

        return result.stream().map(messageDetailDto -> entityToDto(messageDetailDto)).collect(Collectors.toList());

    }

    @Override
    public void save(MessageSaveDto messageSaveDto) {
        Message message = dtoToEntity(messageSaveDto);
        messageRepository.save(message);
    }
}
