package com.web.pocketmoney.exception;

public class CCommentIdFindFailedException extends RuntimeException{
    public CCommentIdFindFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public CCommentIdFindFailedException(String msg) {
        super(msg);
    }

    public CCommentIdFindFailedException() {
        super("해당 댓글이 존재하지 않음");
    }
}
