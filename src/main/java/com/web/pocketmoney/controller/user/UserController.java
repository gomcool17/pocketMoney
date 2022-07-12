package com.web.pocketmoney.controller;

import com.web.pocketmoney.dto.user.AuthUserDTO;
import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
@Log4j2
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    //회원 정보 조회
    @GetMapping("/myPage/{id}")
    public UserDTO readOne(@PathVariable("id") Long id, Model model){

        log.info("controller :: "+ id);

        UserDTO userDTO = userService.getUser(id);
        log.info("userDTO :: "+userDTO);
        model.addAttribute("dto", userDTO);
//        return "redirect:/myPage";
        return userDTO;
    }
}
