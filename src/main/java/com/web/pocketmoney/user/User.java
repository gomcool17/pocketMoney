package com.web.pocketmoney.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
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
    private String userName;
    @Column(nullable = false, length = 10, unique = true)
    private String nickName;
    @Column(nullable = false, length = 20)
    private String password;
    @Column(columnDefinition = "varchar(10) default '남'")
   // @ColumnDefault("남")
    private String sex;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = true, length = 10)
    private String city;
    @Column(nullable = false, length = 50)
    private Long kindScore;

    @CreationTimestamp
    private Timestamp creatdAt;
}
