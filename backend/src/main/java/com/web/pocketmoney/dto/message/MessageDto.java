package com.web.pocketmoney.dto.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {

    public enum MessageType{
        ENTER, COMM
    }

    private MessageType messageType;
    private String roomId;
    private String sender;
    private String message;

    
}
