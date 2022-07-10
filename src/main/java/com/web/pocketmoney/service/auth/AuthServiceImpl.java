package com.web.pocketmoney.service.auth;

import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.entity.user.AuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Primary
public class AuthServiceImpl implements AuthService {

    @Qualifier("AuthRepository")
    private final AuthRepository authRepository;

    @Override
    public UserDTO registerUser(UserDTO UserDtO) {
        return null;
    }

    @Override
    public UserDTO getUserDetailsByEmail(String email) {
        return null;
    }

    @Override
    public UserDTO getUser(String userId) {
        return null;
    }

    @Override
    public UserDTO getRentalsByNickname(String nickname) {
        return null;
    }

    @Override
    public UserDTO getBorrowsByNickname(String nickname) {
        return null;
    }

    @Transactional
    @Override
    public boolean checkNickname(String nickname) {
        return authRepository.existsByNickname(nickname);
    }

    @Transactional
    @Override
    public boolean checkEmail(String email) {
        return authRepository.existsByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
