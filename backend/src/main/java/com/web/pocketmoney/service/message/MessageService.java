package com.web.pocketmoney.service.message;

import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.message.MessageRepository;
import com.web.pocketmoney.entity.message.MessageStatus;
import com.web.pocketmoney.service.room.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class MessageService {

    private MessageRepository repository;
    private ChatRoomService chatRoomService;

    public Message save(Message message) {
        message.setStatus(MessageStatus.RECEIVED);
        repository.save(message);
        return message;
    }

    public long countNewMessages(Long senderId, Long recipientId) {
        return repository.countBySenderIdAndRecipientIdAndStatus(senderId, recipientId, MessageStatus.RECEIVED);
    }

    public List<Message> findChatMessages(Long senderId, Long recipientId) {
        Optional<String> chatId = chatRoomService.getChatId(senderId, recipientId, false);

        List<Message> messages = chatId.map(id -> repository.findByChatId(id)).orElse(new ArrayList<>());

        if(messages.size() > 0){
            updateStatuses(senderId,recipientId,MessageStatus.DELIVERED);
        }
        return messages;
    }

    public Message findById(Long id){
        return repository.findById(id).map(message -> {
            message.setStatus(MessageStatus.DELIVERED);
            return repository.save(message);
        })
                .orElseThrow(()-> new ResourceAccessException("메시지를 찾을 수 없습니다. ("+id+")"));
    }

    public void updateStatuses(Long senderId, Long recipientId, MessageStatus status) {
        repository.updateStatus(senderId, recipientId, status);
    }
}
