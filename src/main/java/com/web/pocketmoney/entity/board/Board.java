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

    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String area;

    @Column(nullable = false)
    private LocalDateTime wantedTime;

    @Column(nullable = false)
    private int dayOfWeek;

    @Column(nullable = false)
    private int pay;

    private int viewCount;

    private int likes;

    @Builder
    public Board(String title, String content, String area, LocalDateTime wantedTime,
                 int dayOfWeek, int pay, int viewCount, int likes) {
        this.title = title;
        this.content = content;
        this.area = area;
        this.wantedTime = wantedTime;
        this.dayOfWeek = dayOfWeek;
        this.pay = pay;
        this.viewCount = viewCount;
        this.likes = likes;
    }

    public void update(String title, String content, String area, LocalDateTime wantedTime,
                       int dayOfWeek, int pay, int viewCount, int likes) {
        this.title = title;
        this.content = content;
        this.area = area;
        this.wantedTime = wantedTime;
        this.dayOfWeek = dayOfWeek;
        this.pay = pay;
        this.viewCount = viewCount;
        this.likes = likes;
    }
}
