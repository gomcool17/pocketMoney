package com.web.pocketmoney.controller.login;

import com.web.pocketmoney.config.security.JwtTokenProvider;
import com.web.pocketmoney.dto.user.SignupUserDTO;
import com.web.pocketmoney.dto.user.TokenUserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.model.CommonResult;
import com.web.pocketmoney.model.SingleResult;
import com.web.pocketmoney.service.ResponseService;
import com.web.pocketmoney.service.UserService;
import com.web.pocketmoney.dto.user.LoginDTO;
import com.web.pocketmoney.service.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
    @PostMapping(value = "/")
    public SingleResult<TokenUserDTO> signin(@RequestBody LoginDTO loginDto) {
        return userService.login(loginDto);
    }

    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @PostMapping(value = "/signup")
    public ResponseEntity<SignupUserDTO> signup(@RequestBody SignupUserDTO signupUserDTO){
        //userService.signup(signupUserDTO);
        return ResponseEntity.ok(userService.signup(signupUserDTO));
    }

//    @ResponseBody
//    @PostMapping("/kakao")
//    public void kakaoLoginToken(@RequestParam String code) {
//        log.info("kakaoLogin code befor access Token : " + code);
//        String accessToken = kakaoApiService.getAccessToken(code);
//        log.info("controllerAcees : " + accessToken);
//        log.info("kakaoLogin Code : " + code);
//        HashMap<String, Object> userInfo = kakaoApiService.getUserInfo(accessToken);
//        log.info("email : " + userInfo.get("email"));
//        log.info("nickname : " + userInfo.get("nickname"));
//
//        String email = userInfo.get("email").toString();
//        String name = userInfo.get("nickName").toString();
//
//        return;
//    }

//    @ResponseBody
//    @GetMapping("/kakao")
//    public void kakaoLogin(@RequestParam String code) {
//        log.info("kakaoLogin code befor access Token : " + code);
//       // String accesToken = kakaoApiService.getAccessToken(code);
//       // log.info("controllerAcees : " + accesToken);
//       // log.info("kakaoLogin Code : " + code);
//        return;
//    }
}
//https://kauth.kakao.com/oauth/authorize?client_id=9b022ce48b033d5d885cb824be69e623&redirect_uri=http://localhost:8080/login/kakao&response_type=code

//kauth.kakao.com/oauth/token?authorization_code&client_id=9b022ce48b033d5d885cb824be69e623&redirect_uri=http://localhost:8080/login/kakao&code=05im7Hel4xi6HJ4bXMlH4Eabyuw2iqPTujkooxqNBsRouK_DqDU6147woemmkS0ekfNuZgo9cxgAAAGCFf2pGg

