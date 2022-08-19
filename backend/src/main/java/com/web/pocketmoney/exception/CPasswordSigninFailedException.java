package com.web.pocketmoney.exception;

public class CPasswordSigninFailedException extends RuntimeException{
    public CPasswordSigninFailedException() { super("비밀번호가 일치하지 않음"); }
}
