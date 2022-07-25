package com.web.pocketmoney.exception;

public class CBoardIndFailedException extends RuntimeException{
    public CBoardIndFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public CBoardIndFailedException(String msg) {
        super(msg);
    }

    public CBoardIndFailedException() {
        super();
    }
}
