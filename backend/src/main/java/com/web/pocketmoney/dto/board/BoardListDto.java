package com.web.pocketmoney.dto.board;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
public class BoardListDto {
    private String title;
    private int view;
    private Timestamp createTime;
  //  private String nickName;
    private int pay;
    private String city;
    private Long boardId;
    private LocalDateTime wantedTime;

    public BoardListDto(String title, int view, Timestamp createTime, String city, int pay, Long boardId, LocalDateTime wantedTime) {
        this.title = title;
        this.view = view;
        this.createTime = createTime;
        this.city = city;
        this.pay = pay;
        this.boardId = boardId;
        this.wantedTime = wantedTime;
    }
}
