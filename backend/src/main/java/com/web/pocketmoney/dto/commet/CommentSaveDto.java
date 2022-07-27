package com.web.pocketmoney.dto.commet;

import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.user.User;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
public class CommentSaveDto {
   // private Long boardId;
    private String text;
}
