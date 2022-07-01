package com.web.pocketmoney.service;

import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        validateDuplicateUserEmail(user);
        validateDuplicateUserNickName(user);
        userRepository.save(user);
        return user;
    }

    public User login(String email, String password) {
        System.out.println("loginService : " + email + " password : " + password );
        List<User> findEmails = userRepository.findByEmail(email);
        if(findEmails.isEmpty()) {
            System.out.println(email + " : " );
            throw new IllegalStateException("존재하지 않는 회원 아이디 입니다");
        }
        User user = findEmails.get(0);
        System.out.println(user.toString());
        if(!user.getPassword().equals(password)) {
            throw new IllegalStateException("비밀번호가 다릅니다.");
        }
        return user;
    }

    private void validateDuplicateUserEmail(User user) {
        List<User> findEmails = userRepository.findByEmail(user.getEmail());
        if(!findEmails.isEmpty()) {
            System.out.println(user.getEmail() + " : ");
            throw new IllegalStateException("이미 존재하는 아이디 입니다.");
        }
    }

    private void validateDuplicateUserNickName(User user) {
        List<User> findNickNames = userRepository.findByNickName(user.getNickName());
        if(!findNickNames.isEmpty()){
            System.out.println(user.getNickName() + " : ");
            throw new IllegalStateException("이미 존재하는 닉네임 입니다.");
        }
    }
}
