package com.web.pocketmoney.entity.message;

import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Message {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageId")
    private Long id;
    @Column(nullable = false)
    private LocalDateTime time;
    @Column(nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "roomId", nullable = false)
    private ChatRoom chatRoom;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User writer;

    public Message(String message, LocalDateTime dateTime, ChatRoom chatRoom, User writer){
        this.message = message;
        this.time = time;
        this.chatRoom = chatRoom;
        this.writer = writer;
    }
}
