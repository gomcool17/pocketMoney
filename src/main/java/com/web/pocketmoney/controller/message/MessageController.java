package com.web.pocketmoney.controller.message;

import com.web.pocketmoney.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {
    /*
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final MessageService messageService;
    @MessageMapping("/chat/send")
    public void sendMessage(MessageForm message) {
        String receiver = message.getReceiver();
        messageService.save(message);
        simpMessagingTemplate.convertAndSend("/topic/"+ receiver,message);
     */
}