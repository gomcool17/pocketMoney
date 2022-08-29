package com.web.pocketmoney.controller.login;

import com.web.pocketmoney.config.security.JwtTokenProvider;
import com.web.pocketmoney.dto.user.KakaoLoginDto;
import com.web.pocketmoney.dto.user.TokenUserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.service.KakaoApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashMap;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
@Log4j2
public class KakaoLoginController {

    private final KakaoApiService kakaoApiService;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwtTokenProvider; // jwt 토큰 생성

    @ResponseBody
    @PostMapping("/kakao")
    public ResponseEntity<KakaoLoginDto> kakaoLoginAccessToken(@RequestParam String code, HttpSession session) {
        log.info("kakaoLogin code befor access Token : " + code);
        String accessToken = kakaoApiService.getAccessToken(code);
        log.info("controllerAcees : " + accessToken);
        log.info("kakaoLogin Code : " + code);
        HashMap<String, Object> userInfo = kakaoApiService.getUserInfo(accessToken);
        log.info("email : " + userInfo.get("email"));
        log.info("name : " + userInfo.get("name"));

        String email = userInfo.get("email").toString();
        String name = userInfo.get("name").toString();
        String gender = userInfo.get("gender").toString();
        if(userInfo.get("gender").toString().equals("male")) {
            log.info("남자");
            gender = "남";
        }
        else {
            log.info("여자");
            gender = "여";
        }
        log.info("최종 : " + name + " "+ email + " " + gender);

        // 새로운 회원이 로그인 할시 어떻게 회원가입을 시켜야할까?
        // ...
        User user = userRepository.findByEmail(email).orElse(null);
        Boolean check = false;

        if(user == null) {
            log.info("신규 유저임");
            userRepository.save(User.builder()
                    .userName(name)
                    .nickName(name)
                    .password(encoder.encode("12345678"))
                    .email(email)
                    .age(0)
                    .city("city")
                    .sex(gender)
                    .roles(Collections.singletonList("ROLE_USER"))
                    .kindScore(0L)
                    .build()
            );
            check = true;
        }

      /*  if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email")); // 세션에 등록
            session.setAttribute("access_Token", accessToken);
        }*/

        user = userRepository.findByEmail(email).orElse(null);
        log.info(user.toString());
        String token = jwtTokenProvider.createToken(String.valueOf(user.getEmail()), user.getRoles());
        log.info("jwt토큰이 생성? : " + token);

        KakaoLoginDto kakaoLoginDto = new KakaoLoginDto();
        kakaoLoginDto.setEmail(email);
        kakaoLoginDto.setName(name);
        kakaoLoginDto.setAccessToken(accessToken);
        kakaoLoginDto.setJwtToken(token);
        if(check) {
            kakaoLoginDto.setIsNew(true);
        }
        else kakaoLoginDto.setIsNew(false);
        //return;
        //return accessToken;
        //aaaaaaa
        //왜 머지가 안되징?

        return ResponseEntity.ok(kakaoLoginDto);
    }

    @ResponseBody
    @GetMapping("/kakao")
    public ResponseEntity<String> kakaoLoginCode(@RequestParam String code) {
        log.info("kakaoLogin get code: " + code);
        return ResponseEntity.ok(code);
    }

  /*  @RequestMapping(value="/kakao/logout")
    public void logout(HttpSession session) {
        String access_Token = (String)session.getAttribute("access_Token");
        log.info("logoutAccessToken : " + access_Token);
        if(access_Token != null && !"".equals(access_Token)){
            kakaoApiService.kakaoLogout(access_Token);
            session.removeAttribute("access_Token");
            session.removeAttribute("userId");
        }else{
            System.out.println("access_Token is null");
            //return "redirect:/";
        }
        return;
    }*/
}
// https://kauth.kakao.com/oauth/authorize?client_id=9b022ce48b033d5d885cb824be69e623&redirect_uri=http://localhost:8080/login/kakao&response_type=code

// https://kauth.kakao.com/oauth/authorize?client_id=9b022ce48b033d5d885cb824be69e623&redirect_uri=http://localhost:3000/login/kakao&response_type=code
