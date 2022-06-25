package com.web.pocketmoney.service;

import com.web.pocketmoney.dto.UserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    //회원 정보 조회
    public UserDTO getUser(Long id){
        Object result = userRepository.getUserById(id);
        Object[] arr = (Object[])result;
        User entity = (User)arr[0];
        return entityToDto(entity);
    }
}
