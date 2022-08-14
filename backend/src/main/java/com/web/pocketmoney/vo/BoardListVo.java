package com.web.pocketmoney.vo;

import lombok.Getter;
import lombok.ToString;

import java.sql.Time;
import java.sql.Timestamp;

@ToString
@Getter
public class BoardListVo implements Comparable<BoardListVo>{
    private Long id;
    private String title;
    private int view;
    private Timestamp createTime;
    private String nickName;

    public BoardListVo(Long id, String title, int view, Timestamp timestamp, String nickName) {
        this.id = id;
        this.title = title;
        this.view = view;
        this.createTime = timestamp;
        this.nickName = nickName;
    }

    @Override
    public int compareTo(BoardListVo b1) {
        if(b1.id > id) {
            return 1;
        }
        else if(b1.id < id) {
            return -1;
        }
        return 0;
    }
}
