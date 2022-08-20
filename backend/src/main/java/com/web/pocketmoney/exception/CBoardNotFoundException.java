package com.web.pocketmoney.exception;

import com.web.pocketmoney.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class CBoardNotFoundException extends RuntimeException {

    private ErrorCode errorCode;

    public CBoardNotFoundException(String msg){
        super(msg);
    }

    public CBoardNotFoundException(String msg, ErrorCode errorCode){
        super(msg);
        this.errorCode = errorCode;
    }
}
