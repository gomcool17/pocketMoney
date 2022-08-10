package com.web.pocketmoney.exception;

import com.web.pocketmoney.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class ChatRoomNotFoundException extends RuntimeException{

    private ErrorCode errorCode;
    public ChatRoomNotFoundException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
