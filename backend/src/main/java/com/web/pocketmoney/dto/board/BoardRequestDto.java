package com.web.pocketmoney.dto.board;

import lombok.Data;

import java.util.List;

@Data
public class BoardRequestDto {
    private String title;
    private String content;
    private String area;
    private List<Integer> dayOfWeek;
    private int[] date = new int[5]; // year, month, day, hour, minute
    private int pay;
   // private User user;
}
