package com.web.pocketmoney.entity.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    long countBySenderIdAndRecipientIdAndStatus(Long senderId, Long recipientId, MessageStatus status);

    List<Message> findByChatId(String chatId);

    @Modifying
    @Query("UPDATE Message mg set mg.status = :status WHERE mg.senderId = :senderId and mg.recipientId = :recipientId ")
    Message updateStatus(Long senderId, Long recipientId, MessageStatus status);
}