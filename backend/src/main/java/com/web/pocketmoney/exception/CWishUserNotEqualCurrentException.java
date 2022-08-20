package com.web.pocketmoney.exception;

import com.web.pocketmoney.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class CWishUserNotEqualCurrentException extends RuntimeException {

    private ErrorCode errorCode;

    public CWishUserNotEqualCurrentException(String msg){
        super(msg);
    }

    public CWishUserNotEqualCurrentException(String msg, ErrorCode errorCode){
        super(msg);
        this.errorCode = errorCode;
    }

}
