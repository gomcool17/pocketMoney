package com.web.pocketmoney.entity.rooms;

import com.web.pocketmoney.entity.room.ChatRoom;
import com.web.pocketmoney.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomsId")
    private Long id;

    @ManyToOne
    @JoinColumn(name ="userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "roomId")
    private ChatRoom chatRoom;
}
