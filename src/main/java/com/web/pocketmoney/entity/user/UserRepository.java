package com.web.pocketmoney.entity.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByNickName(String nickName);

    //PK로 유저 정보 하나 갖고오기
    @Query("select u from User u where u.id = :id")
    Object[] getUserById(@Param("id") Long id);

//    @Query("select u from User u where u.Oauth = :Oauth and u.email = :email")
//    Optional<User> findByEmail(@Param("email") String email, @Param("Oauth") String Oauth);


}
