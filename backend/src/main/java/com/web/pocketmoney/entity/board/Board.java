package com.web.pocketmoney.entity.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.web.pocketmoney.entity.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String area;

    @Column(nullable = false) // 면접 희망 시간
    private LocalDateTime wantedTime;

    //@ElementCollection
    //@CollectionTable(name = "dayOfWeek")
    @Convert(converter = IntegerArrayConverter.class)
    private List<Integer> dayOfWeek;

    @Column(nullable = false) // 희망 시급
    private int pay;

    @Column(columnDefinition = "integer default 0")
    private int view;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
}
