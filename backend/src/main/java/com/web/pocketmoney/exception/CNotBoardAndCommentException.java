package com.web.pocketmoney.exception;

public class CNotBoardAndCommentException extends RuntimeException{
    public CNotBoardAndCommentException() {
        super("게시글 id와 댓글의 id가 일치하지 않음");
    }
}
