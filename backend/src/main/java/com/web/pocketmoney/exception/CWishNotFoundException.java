package com.web.pocketmoney.exception;

import com.web.pocketmoney.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class CWishNotFoundException extends RuntimeException{

    private ErrorCode errorCode;

    public CWishNotFoundException(String message){
        super(message);
    }

    public CWishNotFoundException(String msg, ErrorCode errorCode){
        super(msg);
        this.errorCode = errorCode;
    }
}