package com.web.pocketmoney.exception;

public class CEmailSignupFailedException extends RuntimeException{
    public CEmailSignupFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public CEmailSignupFailedException(String msg) {
        super(msg);
    }

    public CEmailSignupFailedException() {
        super();
    }
}
