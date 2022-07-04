package com.web.pocketmoney.service;

import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    public UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user!= null) {
            return new CustomUserDetails(user);
        }
        return null;
    }
}

/*
    시큐리티 설정에서 loginProcessingUrl 요청이 면 자동으로 UserDetailService타입으로 loc가 되어있는 loadUserByUsername함수가 실행된다.

 */
