package com.web.pocketmoney.dto.board;

import com.web.pocketmoney.entity.board.Board;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String area;
    private LocalDateTime wantedTime;
    private int dayOfWeek;
    private int pay;
    private int viewCount;
    private int likes;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.area = board.getArea();
        this.wantedTime = board.getWantedTime();
        this.dayOfWeek = board.getDayOfWeek();
        this.pay = board.getPay();
        this.viewCount = board.getViewCount();
        this.likes =  board.getLikes();
    }

}