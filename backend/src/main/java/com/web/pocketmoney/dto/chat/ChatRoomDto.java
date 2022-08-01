package com.web.pocketmoney.dto.chat;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomDto {

    private Long id;

    //채팅방 이름
    private String chatId;

    private Long senderId;

    private Long recipientId;
}
