package com.web.pocketmoney.controller;

import com.web.pocketmoney.dto.ResponseDTO;
import com.web.pocketmoney.dto.UserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    //회원 정보 조회
    @GetMapping("/{id}")
    public String readOne(@PathVariable("id") Long id, Model model){
        UserDTO userDTO = userService.getUser(id);
        model.addAttribute("dto", userDTO);
        return "redirect:/mypage";
    }

    //회원 수정
    @PutMapping("/user")
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
}
