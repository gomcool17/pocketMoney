package com.web.pocketmoney.exception;

import com.web.pocketmoney.exception.handler.ErrorCode;
import lombok.Getter;

@Getter
public class CUserNotFoundException extends RuntimeException{

    private ErrorCode errorCode;
    public CUserNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public CUserNotFoundException(String msg) {
        super(msg);
    }

    public CUserNotFoundException() {
        super("해당 유저를 찾을 수 없음");
    }

    public CUserNotFoundException(String msg, ErrorCode errorCode) {
        super(msg);
        this.errorCode = errorCode;

    }
}
