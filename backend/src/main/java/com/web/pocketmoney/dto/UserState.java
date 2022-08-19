package com.web.pocketmoney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserState {
    USER, NOTUSER, NOLOGIN;

}
