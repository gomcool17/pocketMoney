package com.web.pocketmoney.service;

import com.web.pocketmoney.dto.UserDTO;
import com.web.pocketmoney.entity.user.User;

public interface UserService {


    //회원 정보 조회
    UserDTO getUser(Long id);

    void modify(User user);

    default UserDTO entityToDto(User user){
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .roleSet(user.getRoleSet())
                .regDate(user.getRegDate())
                .username(user.getUsername())
                .password(user.getPassword())
                .sex(user.getSex())
                .nickname(user.getNickname())
                .age(user.getAge())
                .city(user.getCity())
                .kindScore(user.getKindScore())
                .build();

        return userDTO;
    }

    default User DtoToEntity(UserDTO userDTO){
        User user =  User.builder()
                .id(userDTO.getId())
                .roleSet(userDTO.getRoleSet())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .sex(userDTO.getSex())
                .nickname(userDTO.getNickname())
                .age(userDTO.getAge())
                .city(userDTO.getCity())
                .kindScore(userDTO.getKindScore())
                .build();
        return user;
    }
}
