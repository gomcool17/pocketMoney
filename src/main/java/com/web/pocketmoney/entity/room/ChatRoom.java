package com.web.pocketmoney.entity.room;

import com.web.pocketmoney.entity.message.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ChatRoom {
    @Id @GeneratedValue
    @Column(name = "roomId")
    private Long id;

    @OneToMany(mappedBy = "chatRoom")
    private List<Message> messages = new ArrayList<>();
}
