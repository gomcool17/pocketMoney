package com.web.pocketmoney.controller.login;

import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> save(@RequestBody User user) {

        return new ResponseEntity<User>(userService.save(user), HttpStatus.OK);
    }
}
