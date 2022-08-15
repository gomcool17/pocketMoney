package com.web.pocketmoney.dto.commet;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class CommentListDto {
    private Long id;
    private String content;
    private String nickName;
    private Timestamp timestamp;

    public CommentListDto(Long id, String content, String nickName, Timestamp timestamp) {
        this.id = id;
        this.content = content;
        this.nickName = nickName;
        this.timestamp = timestamp;
    }
}
