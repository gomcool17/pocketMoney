package com.web.pocketmoney.service.message;

import com.web.pocketmoney.dto.message.MessageDetailDto;
import com.web.pocketmoney.dto.message.MessageSaveDto;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.message.MessageRepository;
import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.room.ChatRoomRepository;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.exception.CMessageNotFoundException;
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
    private final UserRepository userRepository;

    @Override
    public List<MessageDetailDto> findAllChatByRoomId(Long id, Long userId) {

        ChatRoom chatRoom =  chatRoomRepository.findById(id)
                .orElseThrow(() -> new ChatRoomNotFoundException(
                        "찾는 방이 없습니다.", ErrorCode.FORBIDDEN
                ));

        List<Message> result = messageRepository.findAllByChatRoom_RoomId(chatRoom.getId());

        return result.stream().map(message -> entityToDto(message, userId)).collect(Collectors.toList());

    }

    @Override
    public Long save(MessageSaveDto messageSaveDto) {
        Message message = dtoToEntity(messageSaveDto);
        messageRepository.save(message);

        return message.getId();
    }

    @Override
    public MessageDetailDto findOne(Long messageId, Long userId) {

        Message message = messageRepository.findById(messageId).orElseThrow(()->
                new CMessageNotFoundException("해당 메세지는 이미 삭제되었습니다.", ErrorCode.FORBIDDEN));

        return entityToDto(message, userId);

    }

    MessageDetailDto entityToDto(Message message, Long userId){

        MessageDetailDto messageDetailDto = MessageDetailDto.builder()
                .messageId(message.getId())
                .sendDate(message.getSendDate())
                .chatRoomId(message.getChatRoom().getId())
                .roomName(message.getChatRoom().getRoomName())
                .writer(message.getWriterNickName())
                .writerId(userRepository.findByNickName(message.getWriterNickName()).getId())
                .myId(userId)
                .message(message.getMessage())
                .build();
        return messageDetailDto;
    }
}
