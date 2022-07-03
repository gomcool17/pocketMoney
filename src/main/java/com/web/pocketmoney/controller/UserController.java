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


}
