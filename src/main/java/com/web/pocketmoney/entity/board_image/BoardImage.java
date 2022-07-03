package com.web.pocketmoney.entity.board_image;

import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class BoardImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User userId;

    @ManyToOne
    private Board boardId;

    @Column(nullable = false)
    private String imageName;
}
