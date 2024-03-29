package com.web.pocketmoney.entity.user;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    User findByNickName(String nickName);
  //  Optional<User> findById(String id);

    Optional<User> findById(Long id);


  //  Optional<User> findById(Long id);


    //PK로 유저 정보 하나 갖고오기
//    @Query("select u from User u where u.id = :id")
//    Object[] getUserById(@Param("id") Long id);

//    @Query("select u from User u where u.Oauth = :Oauth and u.email = :email")
//    Optional<User> findByEmail(@Param("email") String email, @Param("Oauth") String Oauth);


}
