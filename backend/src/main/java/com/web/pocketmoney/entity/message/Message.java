package com.web.pocketmoney.entity.message;


import com.web.pocketmoney.dto.message.MessageSaveDto;
import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.user.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chatRoom_id")
    private ChatRoom chatRoom;

    //보내는 사람
    private String writer;

    @Column
    private String message;

//    //보내는 사람 닉네임
//    private String senderName;
//    //받는 사람 닉네임
//    private String recipientName;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime sendDate;

    //메시지를 보낸 상태
//    private MessageStatus status;

    public static Message toChatEntity(MessageSaveDto messageSaveDto, ChatRoom chatRoom){
        Message message = new Message();

        message.setChatRoom(chatRoom);

        message.setWriter(messageSaveDto.getWriter());
        message.setMessage(messageSaveDto.getMessage());

        return message;
    }
}
