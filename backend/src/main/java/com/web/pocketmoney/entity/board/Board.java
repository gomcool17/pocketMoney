package com.web.pocketmoney.entity.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.web.pocketmoney.entity.comment.Comment;
import com.web.pocketmoney.entity.user.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "boardId", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    @Column(nullable = true)
    private String fileKey;

    @Column(nullable = true)
    private String filePath;

    @Column(nullable = false) // 희망 시급
    private int pay;

    @Column(columnDefinition = "integer default 0")
    private int view;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @CreationTimestamp
    private Timestamp createTime;

    @UpdateTimestamp
    private Timestamp updateTime;
}
