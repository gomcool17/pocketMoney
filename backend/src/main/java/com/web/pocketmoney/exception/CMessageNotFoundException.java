package com.web.pocketmoney.exception;

import com.web.pocketmoney.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class CMessageNotFoundException extends RuntimeException{

    private ErrorCode errorCode;

    public CMessageNotFoundException(String msg){
        super(msg);
    }
    public CMessageNotFoundException(String msg, ErrorCode errorCode){
        super(msg);
        this.errorCode = errorCode;
    }

}
