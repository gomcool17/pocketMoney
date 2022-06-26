package com.web.pocketmoney.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(nullable = false, length = 50)
    private String userName; // 사용자 이름

    @Column(nullable = false, length = 100, unique=true)
    private String email; // 회원가입 할때 아이디가 될 것

    @Column(nullable = false, length = 10, unique = true)
    private String nickName; // 닉네임

    @Column(nullable = false, length = 20)
    private String password;

    @Column(columnDefinition = "varchar(10) default '남'")
    private String sex;

    private Integer age;

    @Column(length = 10)
    private String city;

    private Long kindScore;

    @CreationTimestamp
    private Timestamp creatdAt;
}
