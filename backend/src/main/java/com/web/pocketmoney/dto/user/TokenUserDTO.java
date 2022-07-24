package com.web.pocketmoney.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenUserDTO {
    private String token;
    private Long userId;
    private String nickName;
}
