package com.web.pocketmoney.controller.login;

import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.service.UserService;
import com.web.pocketmoney.dto.LoginDto;
import com.web.pocketmoney.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
public class LoginController {


    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> save(@RequestBody User user) {

        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<User> login(@RequestBody LoginDto loginDto) {
        System.out.println("LOgin controller : " + loginDto.getEmail() + "입니다.");

        return new ResponseEntity<User>(userService.login(loginDto.getEmail(), loginDto.getPassword()), HttpStatus.OK);
    }
}
