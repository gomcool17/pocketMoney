package com.web.pocketmoney.entity.user;

import com.web.pocketmoney.entity.base.BaseEntity;
import com.web.pocketmoney.entity.role.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<UserRole> roleSet = new HashSet<>();

    @Column(nullable = false, length = 50)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 2)
    private String sex;

    @Column(nullable = false, length = 10)
    private String nickname;

    @Column(nullable = false)
    private int age;

    @Column(length = 10)
    private String city;

    @Column(nullable = false)
    private Long kindScore;

    //권한 부여 추가, 스프링 시큐리티
    public void addUserRole(UserRole userRole){
        roleSet.add(userRole);
    }







}
