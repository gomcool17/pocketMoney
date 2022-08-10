package com.web.pocketmoney.dto.board;

import java.util.List;

public class BoardUpdateRequestDto {
    private String title;
    private String content;
    private String area;
    private List<Integer> dayOfWeek;
    private int[] date = new int[5]; // year, month, day, hour, minute
    private int pay;
}
