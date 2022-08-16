package com.web.pocketmoney.dto.commet;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommentResponseSaveDto {
    private String text;
    private String nickName;
}
