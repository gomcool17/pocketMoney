package com.web.pocketmoney.dto.board;

import com.web.pocketmoney.entity.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String title;
    private String content;
    private String area;
    private LocalDateTime wantedTime;
    private int dayOfWeek;
    private int pay;
    private int viewCount;
    private int likes;

    @Builder
    public BoardSaveRequestDto(String title, String content, String area, LocalDateTime wantedTime,
                               int dayOfWeek, int pay, int viewCount, int likes) {
        this.title = title;
        this.content = content;
        this.area = area;
        this.wantedTime = wantedTime;
        this.dayOfWeek = dayOfWeek;
        this.pay = pay;
        this.viewCount = viewCount;
        this.likes = likes;
    }

    public Board toEntity() {
        Board board = Board.builder()
                .title(title)
                .content(content)
                .area(area)
                .wantedTime(wantedTime)
                .dayOfWeek(dayOfWeek)
                .pay(pay)
                .viewCount(viewCount)
                .likes(likes)
                .build();

        return board;
    }

}

