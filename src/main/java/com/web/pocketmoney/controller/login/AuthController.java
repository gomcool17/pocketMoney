package com.web.pocketmoney.controller.login;

import com.web.pocketmoney.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Slf4j
@RequestMapping("/")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // nickname과 email의 중복 체크

    @GetMapping("/check/nickname/{nickname}")
    public ResponseEntity<?> checkNickname(@PathVariable("nickname") String nickname){
        log.info("Auth Service's Controller Layer :: Call checkNickname Method!");

        if(authService.checkNickname(nickname)){
            return ResponseEntity.status(HttpStatus.OK).body(false);
        }
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @GetMapping("check/email/{email}")
    public ResponseEntity<?> checkEmail(@PathVariable("email") String email){
        log.info("Auth Service's Controller Layer :: Call checkNickname Method!");

        if(authService.checkEmail(email)){
            return ResponseEntity.status(HttpStatus.OK).body(false);
        }

        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(){
        log.info("Auth Service's Controller Layer :: Call logout Method!");

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Successfully logout");
    }
}
