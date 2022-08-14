package com.web.pocketmoney.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Criteria;

@Getter
@Setter
@ToString
public class PageVo {
    private int startPage;
    private int endPage;
    private boolean prev, next;
    private int amount = 2;
    private double amount2 = 2.0;

    private int total; // 전체 페이지 번호

    private CriteriaVo cri;

    public PageVo(CriteriaVo cri, int total) {
        this.cri = cri;
        this.total = total;

        //시작페이지, 마지막페이지 계산
        this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
        this.startPage = this.endPage -9;

        int realEnd = (int) (Math.ceil(total * 1.0 / cri.getAmount()));

        if(realEnd < this.endPage) {
            this.endPage = realEnd;
        }

        //이전, 다음 버튼 표출 여부 결정
        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
