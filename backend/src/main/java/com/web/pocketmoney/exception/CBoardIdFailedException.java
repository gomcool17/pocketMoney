package com.web.pocketmoney.exception;

import com.web.pocketmoney.exception.handler.ErrorCode;

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

    private ErrorCode errorCode;
    public CBoardIdFailedException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
