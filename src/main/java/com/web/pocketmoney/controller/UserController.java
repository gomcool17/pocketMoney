package com.web.pocketmoney.controller;

import com.web.pocketmoney.dto.UserDTO;
import com.web.pocketmoney.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    //회원 정보 조회
    @GetMapping("/{id}")
    public String readOne(@PathVariable("id") Long id, Model model){
        UserDTO userDTO = userService.getUser(id);
        model.addAttribute("dto", userDTO);
        return "redirect:/mypage";
    }
}
