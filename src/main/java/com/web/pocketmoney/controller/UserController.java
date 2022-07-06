package com.web.pocketmoney.controller;

import com.web.pocketmoney.dto.user.AuthUserDTO;
import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

 /*   private final UserService userService;

    private final AuthenticationManager authenticationManager;

    //회원 정보 조회
    @GetMapping("/{id}")
    public String readOne(@AuthenticationPrincipal AuthUserDTO authUserDTO, @PathVariable("id") Long id, Model model){

        UserDTO userDTO = userService.getUser(id);
        model.addAttribute("dto", userDTO);
        return "redirect:/mypage";
    }*/
}
