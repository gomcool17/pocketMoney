package com.web.pocketmoney.controller.login;

import com.web.pocketmoney.config.security.JwtTokenProvider;
import com.web.pocketmoney.dto.user.SignupUserDTO;
import com.web.pocketmoney.dto.user.TokenUserDTO;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.model.SingleResult;
import com.web.pocketmoney.service.ResponseService;
import com.web.pocketmoney.service.user.UserService;
import com.web.pocketmoney.dto.user.LoginDTO;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
@Log4j2
public class LoginController {

    private final UserRepository userRepository; // jpa 쿼리 활용
    private final JwtTokenProvider jwtTokenProvider; // jwt 토큰 생성
    private final UserService userService; // API 요청 결과에 대한 code, messageㅍ
    private final PasswordEncoder passwordEncoder; // 비밀번호 암호화
    private final ResponseService responseService; // API 요청 결과에 대한 code, message
    //private final KakaoApiService kakaoApiService;

    // private final UserService userService;

    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인을 한다.")
    @PostMapping    (value = "/")
    public SingleResult<TokenUserDTO> signin(@RequestBody LoginDTO loginDto) {
        return userService.login(loginDto);
    }

    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @PostMapping(value = "/signup")
    public ResponseEntity<SignupUserDTO> signup(@RequestBody SignupUserDTO signupUserDTO){
        //userService.signup(signupUserDTO);
        return ResponseEntity.ok(userService.signup(signupUserDTO));
    }

}
