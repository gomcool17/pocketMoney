package com.web.pocketmoney.controller.login;

import com.web.pocketmoney.dto.user.ResponseDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserApiController {

  /*  private final UserService userService;

    private final AuthenticationManager authenticationManager;

    //회원 수정
    @PutMapping("")
    public ResponseDTO<Integer> update(@RequestBody User user){
        //RequestBody가 없을 경우, Json을 못 받는다. key=value로만 받을 수 있다.
        userService.modify(user);

        //세션 등록
        //어썬티케이션 매니저에게 유저네임과 패스워드를 던져서
        //매니저가 자동으로 세션등록 해준다.
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("{id}")
    public ResponseDTO<Integer> delete(@PathVariable Long id){
        User user = userService.DtoToEntity(userService.getUser(id));
        userService.delete(user);

        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }*/
}
