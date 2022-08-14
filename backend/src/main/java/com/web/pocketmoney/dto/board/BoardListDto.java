package com.web.pocketmoney.dto.board;

import ch.qos.logback.core.joran.action.TimestampAction;
import com.web.pocketmoney.vo.BoardListVo;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BoardListDto {
    private String title;
    private int view;
    private Timestamp createTime;
    private String nickName;

    public BoardListDto(String title, int view, Timestamp createTime, String nickName) {
        this.title = title;
        this.view = view;
        this.createTime = createTime;
        this.nickName = nickName;
    }
}
