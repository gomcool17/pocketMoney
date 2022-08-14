package com.web.pocketmoney.dto.board;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardHomeResponserDto {
    private List<BoardHomeDto> boards;

    public BoardHomeResponserDto(List<BoardHomeDto> boards) {
        this.boards = boards;
    }
}
