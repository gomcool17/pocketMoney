package com.web.pocketmoney.exception;

public class CNoBoardAndUserException extends RuntimeException{
    public CNoBoardAndUserException(String msg, Throwable t) {
        super(msg, t);
    }

    public CNoBoardAndUserException(String msg) {
        super(msg);
    }

    public CNoBoardAndUserException() {
        super("해당 유저가 작성한 게시글이 아니다.");
    }
}
