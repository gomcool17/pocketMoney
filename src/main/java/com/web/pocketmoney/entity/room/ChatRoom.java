package com.web.pocketmoney.entity.room;

import com.web.pocketmoney.entity.message.Message;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ChatRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private String id;

    private String chatId;

    private Long senderId;

    private Long recipientId;
}