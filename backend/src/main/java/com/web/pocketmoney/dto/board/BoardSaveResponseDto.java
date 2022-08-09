package com.web.pocketmoney.dto.board;

import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.user.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BoardSaveResponseDto {
    private String title;
    private String content;
    private String area;
    //private LocalDateTime wantedTime;
    private List<Integer> dayOfWeek;
    private int[] date = new int[5]; // year, month, day, hour, minute
    private int pay;
    private int view;
    private String nickName;
}
