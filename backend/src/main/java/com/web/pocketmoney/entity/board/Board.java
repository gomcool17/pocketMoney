package com.web.pocketmoney.entity.board;

import com.web.pocketmoney.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(nullable = false) // 희망 근무 요일
    private int dayOfWeek;

    @Column(nullable = false) // 희망 시급
    private int pay;

    @Column(columnDefinition = "integer default 0")
    private int view;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;



    @Builder
    public Board(String title, String content, String area, LocalDateTime wantedTime,
                 int dayOfWeek, int pay) {
        this.title = title;
        this.content = content;
        this.area = area;
        this.wantedTime = wantedTime;
        this.dayOfWeek = dayOfWeek;
        this.pay = pay;
    }

    public void update(String title, String content, String area, LocalDateTime wantedTime,
                       int dayOfWeek, int pay) {
        this.title = title;
        this.content = content;
        this.area = area;
        this.wantedTime = wantedTime;
        this.dayOfWeek = dayOfWeek;
        this.pay = pay;
    }
}
