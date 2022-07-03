package com.web.pocketmoney.entity.resume;

import com.web.pocketmoney.entity.user.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;

    @CreatedDate
    @Column(name = "startDate", updatable = false)
    private LocalDateTime startDate;

    @LastModifiedDate
    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, length = 255)
    private String content;



}
