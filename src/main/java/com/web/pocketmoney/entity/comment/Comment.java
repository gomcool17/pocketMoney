package com.web.pocketmoney.entity.comment;

import com.web.pocketmoney.entity.base.BaseEntity;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.user.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
    @ManyToOne(fetch = FetchType.LAZY)
    private Board boardId;
    private String text;
}
