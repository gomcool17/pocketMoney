package com.web.pocketmoney.entity.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    public User findByNickName(String nickNmae);
    //PK로 유저 정보 하나 갖고오기
    @Query("select * from User where id = :id")
    Object[] getUserById(@Param("id") Long id);
}
