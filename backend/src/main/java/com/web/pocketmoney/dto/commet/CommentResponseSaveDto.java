package com.web.pocketmoney.dto.commet;

import lombok.Builder;

@Builder
public class CommentResponseSaveDto {
    private String text;
    private String nickName;
}
