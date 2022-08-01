package com.web.pocketmoney.entity.message;


import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.user.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageId")
    private Long id;

    //메시지가 들어있는 채팅방
    @ManyToOne(fetch = FetchType.LAZY)
    private ChatRoom chatId;

    //보내는 사람
    @ManyToOne(fetch = FetchType.LAZY)
    private User senderId;

    //받는 사람
    @ManyToOne(fetch = FetchType.LAZY)
    private User recipientId;

    //보내는 사람 닉네임
    private String senderName;
    //받는 사람 닉네임
    private String recipientName;
    //메시지 내용
    private String content;

    //메시지 보낸 날짜
    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime timestamp;

    //메시지를 보낸 상태
    private MessageStatus status;
}
