package com.web.pocketmoney.dto.board;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardResponseListDto {
    private List<BoardListDto> boards;
    private int start;
    private int end;
    private boolean prev, next;

    public BoardResponseListDto(List<BoardListDto> boards, int start, int end, boolean prev, boolean next) {
        this.boards = boards;
        this.start = start;
        this.end = end;
        this.prev = prev;
        this.next = next;
    }
}
