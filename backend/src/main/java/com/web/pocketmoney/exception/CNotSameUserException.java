package com.web.pocketmoney.exception;

public class CNotSameUserException extends RuntimeException{
    public CNotSameUserException(String msg, Throwable t) {
        super(msg, t);
    }

    public CNotSameUserException(String msg) {
        super(msg);
    }

    public CNotSameUserException() {
        super("해당 유저의 권한이 아님(작성자랑 유저가 같지 않음)");
    }
}
