package com.web.pocketmoney.entity.user;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByUserId(String userId);

    boolean existsByNickname(String nickname);

    boolean existsByEmail(String email);


}
