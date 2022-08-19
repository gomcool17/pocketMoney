package com.web.pocketmoney.service.user;

import com.web.pocketmoney.dto.user.LoginDTO;
import com.web.pocketmoney.dto.user.SignupUserDTO;
import com.web.pocketmoney.dto.user.TokenUserDTO;
import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.model.SingleResult;

public interface UserService {

    //회원 정보 조회
    UserDTO getUser(Long id);

    void modify(UserDTO userDTO, User user);

    void delete(Long id);

    default UserDTO entityToDto(User user){
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .roleSet(user.getRoles())
//                .regDate(user.getRegDate())
                .userName(user.getUsername())
                .password(user.getPassword())
                .sex(user.getSex())
                .nickName(user.getNickName())
                .age(user.getAge())
                .city(user.getCity())
                .kindScore(user.getKindScore())
                .build();

        return userDTO;
    }

    default User DtoToEntity(UserDTO userDTO){
        User user =  User.builder()
                .id(userDTO.getId())
                .roles(userDTO.getRoleSet())
                .userName(userDTO.getUserName())
                .password(userDTO.getPassword())
                .sex(userDTO.getSex())
                .nickName(userDTO.getNickName())
                .age(userDTO.getAge())
                .city(userDTO.getCity())
                .kindScore(userDTO.getKindScore())
                .build();
        return user;
    }
    SingleResult<TokenUserDTO> login(LoginDTO loginDto);
    SignupUserDTO signup(SignupUserDTO signupUserDTO);
}
