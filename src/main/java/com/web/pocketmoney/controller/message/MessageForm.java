package com.web.pocketmoney.controller.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageForm {
    private Long RoomId;
    private String receiver;
    private String sender;
    private String message;
}
