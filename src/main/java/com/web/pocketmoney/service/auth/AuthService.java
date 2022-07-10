package com.web.pocketmoney.service.auth;

import com.web.pocketmoney.dto.user.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    // UserDetailsService는 DB에서 유저 정보를 가져오는 역할을 한다. Spring Security에서 사용자의 정보를 담는 인터페이스이다.

    UserDTO registerUser(UserDTO UserDtO);

    UserDTO getUserDetailsByEmail(String email);

    UserDTO getUser(String userId);

    UserDTO getRentalsByNickname(String nickname);

    UserDTO getBorrowsByNickname(String nickname);

    boolean checkNickname(String nickname);

    boolean checkEmail(String email);
}
