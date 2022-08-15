package com.web.pocketmoney.dto.commet;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CommentResponseListDto {
    private List<CommentListDto> comments;
    private int start;
    private int end;
    private boolean prev, next;

    public CommentResponseListDto(List<CommentListDto> commets, int start, int end, boolean prev, boolean next) {
        this.comments = commets;
        this.start = start;
        this.end = end;
        this.prev = prev;
        this.next = next;
    }
}
