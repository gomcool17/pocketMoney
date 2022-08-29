package com.web.pocketmoney.dto.board;

import com.web.pocketmoney.dto.UserState;
import com.web.pocketmoney.entity.board.Board;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BoardDto {
    private String title;
    private String content;
    private String area;
    private List<Integer> dayOfWeek;
    private LocalDateTime date;
    private int pay;
    private int view;
    private String nickName;
    private UserState isUser;
    private String filePath;
    //private int isUser; //
}
