package com.web.pocketmoney.dto.user;

import lombok.Data;

@Data
public class KakaoLoginDto {
    private String accessToken;
    private String email;
    private String name;
}
