package com.web.pocketmoney.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CriteriaVo {
    private int pageNum;
    private int amount;
    private int start, end; // list에 표시할 게시글들
    private int total;
    public CriteriaVo(int amount, int total) {
        this.amount = amount;
        this.total = total;
    }

    // 기본 생성자 설정
    public CriteriaVo(int pageNum, int amount, int total) {
        this.pageNum = pageNum;
        this.amount = amount;
        start = (pageNum-1) * amount;
        end = start + amount-1;
        if(end >= total) end = total-1;
    }
}
