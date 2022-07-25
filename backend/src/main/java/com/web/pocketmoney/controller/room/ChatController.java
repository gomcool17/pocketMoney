package com.web.pocketmoney.controller.room;

import com.web.pocketmoney.entity.message.ChatNotification;
import com.web.pocketmoney.entity.message.Message;
import com.web.pocketmoney.service.message.MessageService;
import com.web.pocketmoney.service.room.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private SimpMessagingTemplate messagingTemplate;
    private MessageService messageService;
    private ChatRoomService chatRoomService;

    @MessageMapping("/chat")
    public void proccessMessage(@Payload Message message) {
        Optional<String> chatId = chatRoomService.getChatId(message.getSenderId(), message.getRecipientId(), true);
        message.setChatId(chatId.get());

        Message saved = messageService.save(message);
        messagingTemplate.convertAndSendToUser(
                String.valueOf(message.getRecipientId()), "/queue/messages",
                new ChatNotification(saved.getId(), saved.getSenderId(), saved.getSenderName()));
    }

    @GetMapping("/room/{senderId}/{recipientId}/count")
    public ResponseEntity<Long> countNewMessages(@PathVariable Long sederId, @PathVariable Long recipientId) {
        return ResponseEntity.ok(messageService.countNewMessages(sederId,recipientId));
    }

    @GetMapping("/room/{senderId}/{recipientId}")
    public ResponseEntity<?> findChatMessages(@PathVariable Long senderId, @PathVariable Long recipientId) {
        return ResponseEntity.ok(messageService.findChatMessages(senderId,recipientId));
    }

    @GetMapping("/room/messages/{id}")
    public ResponseEntity<?> findMessage(@PathVariable Long id) {
        return ResponseEntity.ok(messageService.findById(id));
    }
}
