package com.web.pocketmoney.dto.board;

import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequestDto {

    private Long id;
    private String title;
    private String content;
    private String area;
    private LocalDateTime wantedTime;
    private int dayOfWeek;
    private int pay;
    private int view;
    private User user;

    public Board toEntity() {
        Board board = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .area(area)
                .wantedTime(wantedTime)
                .dayOfWeek(dayOfWeek)
                .pay(pay)
                .view(0)
                .build();

        return board;
    }

}

