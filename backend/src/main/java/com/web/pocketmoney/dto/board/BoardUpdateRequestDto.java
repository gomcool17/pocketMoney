package com.web.pocketmoney.dto.board;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardUpdateRequestDto {

    private String title;
    private String content;
    private String area;
    private LocalDateTime wantedTime;
    private int dayOfWeek;
    private int pay;
    private int viewCount;
    private int likes;

    @Builder
    public BoardUpdateRequestDto(String title, String content, String area, LocalDateTime wantedTime,
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

}