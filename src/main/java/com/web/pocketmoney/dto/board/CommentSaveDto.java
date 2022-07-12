package com.web.pocketmoney.dto.board;

import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.user.User;
import lombok.Data;

import javax.persistence.*;

@Data
public class CommentSaveDto {
   // private Long boardId;
    private String text;
}
