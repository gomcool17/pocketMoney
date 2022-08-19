package com.web.pocketmoney.exception;

public class CUserNotFoundException extends RuntimeException{
    public CUserNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

    public CUserNotFoundException(String msg) {
        super(msg);
    }

    public CUserNotFoundException() {
        super("해당 유저를 찾을 수 없음");
    }
}
