package com.web.pocketmoney.dto.board;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BoardResponseDto {
    private String title;
    private String content;
    private String area;
    private List<Integer> dayOfWeek;
    private LocalDateTime date;
    private int pay;
    private int view;
    private String nickName;
    private String fileKey;
    private String filePath;
}
