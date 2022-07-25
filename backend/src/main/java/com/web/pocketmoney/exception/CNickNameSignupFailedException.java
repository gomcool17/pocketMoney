package com.web.pocketmoney.exception;

public class CNickNameSignupFailedException extends RuntimeException{
    public CNickNameSignupFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public CNickNameSignupFailedException(String msg) {
        super(msg);
    }

    public CNickNameSignupFailedException() {
        super();
    }
}
