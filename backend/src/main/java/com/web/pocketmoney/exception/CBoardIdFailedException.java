package com.web.pocketmoney.exception;

public class CBoardIdFailedException extends RuntimeException{
    public CBoardIdFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public CBoardIdFailedException(String msg) {
        super(msg);
    }

    public CBoardIdFailedException() {
        super("해당 게시글이 존재하지 않음");
    }
}
