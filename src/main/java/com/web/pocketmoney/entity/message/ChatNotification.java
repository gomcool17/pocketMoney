package com.web.pocketmoney.entity.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ChatNotification {
    @Id
    private Long id;
    private Long senderId;
    private String senderName;
}
