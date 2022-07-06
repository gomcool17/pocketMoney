package com.web.pocketmoney.service;

import com.web.pocketmoney.dto.user.AuthUserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.exception.CUserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springfox.documentation.service.OAuth;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail){
        return userRepository.findByEmail(userEmail).orElseThrow(CUserNotFoundException::new);
      /*  User user = userRepository.findByEmail(username);
        if(user!=null) {
            return new CustomUserDetails(user);
        }

        AuthUserDTO authUser = new AuthUserDTO(
                user.getEmail(),
                user.getPassword(),
                user.getOauth(),
                user.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name())).collect(Collectors.toSet())
        );

        authUser.setName(user.getUserName());
        authUser.setOAuth(user.getOauth());

        return authUser;*/
    }
}

/*
    시큐리티 설정에서 loginProcessingUrl 요청이 면 자동으로 UserDetailService타입으로 loc가 되어있는 loadUserByUsername함수가 실행된다.

 */
