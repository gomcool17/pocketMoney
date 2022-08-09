//package com.web.pocketmoney.entity.room;
//
//import com.web.pocketmoney.entity.base.BaseEntity;
//import com.web.pocketmoney.entity.message.Message;
//import com.web.pocketmoney.entity.user.User;
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@Getter
//public class ChatRoom2 extends BaseEntity {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "roomId")
//    private Long id;
//
//    private String chatId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User senderId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User recipientId;
//}