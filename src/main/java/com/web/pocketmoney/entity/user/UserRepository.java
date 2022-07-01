package com.web.pocketmoney.entity.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    public List<User> findByEmail(String email);
    public List<User> findByNickName(String nickNmae);

}
