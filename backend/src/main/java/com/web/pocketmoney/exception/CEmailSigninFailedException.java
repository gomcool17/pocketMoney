package com.web.pocketmoney.exception;

public class CEmailSigninFailedException extends RuntimeException {
    public CEmailSigninFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public CEmailSigninFailedException(String msg) {
        super(msg);
    }

    public CEmailSigninFailedException() {
        super("해당 계정이 존재하지 않음");
    }
}
