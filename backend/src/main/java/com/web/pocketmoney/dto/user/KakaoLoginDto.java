package com.web.pocketmoney.dto.user;

import lombok.Data;

@Data
public class KakaoLoginDto {
    private String accessToken;
    private String jwtToken;
    private String email;
    private String name;
    private Boolean isNew;
}
