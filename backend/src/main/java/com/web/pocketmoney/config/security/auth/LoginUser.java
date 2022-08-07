package com.web.pocketmoney.config.security.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 파라미터로 선언된 객체만 사용
@Retention(RetentionPolicy.RUNTIME) //런타임까지 남아있는다.
public @interface LoginUser {
}

