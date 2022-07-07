package com.web.pocketmoney.service.message;

import com.web.pocketmoney.controller.message.MessageForm;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.entity.message.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Log4j2
public class MessageService {

    private final MessageRepository messageRepository;


    public Message save(MessageForm message) {
        Message chattingmessage = new Message(message.getMessage(), LocalDateTime.now(), /*user객체 가져와야 함*/);
        messageRepository.save(chattingmessage);
    }
}
