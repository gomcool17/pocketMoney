package com.web.pocketmoney.dto.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardHomeDto {
    private String title;
    private int pay;
    private String city;

    public BoardHomeDto(String title, int pay, String city) {
        this.title = title;
        this.pay = pay;
        this.city = city;
    }
}
