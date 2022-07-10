package com.web.pocketmoney.service;

import com.web.pocketmoney.dto.user.LoginDTO;
import com.web.pocketmoney.dto.user.SignupUserDTO;
import com.web.pocketmoney.dto.user.TokenUserDTO;
import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.model.SingleResult;

public interface UserService {

    //회원 정보 조회
  /*  UserDTO getUser(Long id);

    void modify(User user);

    void delete(User user);*/

  /*  default UserDTO entityToDto(User user){
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .roleSet(user.getRoles())
                .regDate(user.getRegDate())
                .username(user.getUsername())
                .password(user.getPassword())
                .sex(user.getSex())
                .nickname(user.getNickName())
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
                .userName(userDTO.getUsername())
                .password(userDTO.getPassword())
                .sex(userDTO.getSex())
                .nickName(userDTO.getNickname())
                .age(userDTO.getAge())
                .city(userDTO.getCity())
                .kindScore(userDTO.getKindScore())
                .build();
        return user;
    }*/
    SingleResult<TokenUserDTO> login(LoginDTO loginDto);
    void signup(SignupUserDTO signupUserDTO);
}
