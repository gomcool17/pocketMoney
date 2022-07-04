package com.web.pocketmoney.handler;

import com.web.pocketmoney.dto.user.AuthUserDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class LoginSuccesshandler implements AuthenticationSuccessHandler {

    // 소셜로그인시 URL 다르게 지정?
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private PasswordEncoder passwordEncoder;

    public LoginSuccesshandler(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

//    로그인 성공시 security에 의해 자동으로 호출되는 메소드
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        AuthUserDTO authUser = (AuthUserDTO) authentication.getPrincipal();
        String Oauth = authUser.getOAuth();

//        boolean passwordResult = passwordEncoder.matches("1234", authUser.getPassword());

//        if(!Oauth.isEmpty() && passwordResult){
//            redirectStrategy.sendRedirect(request, response, "/user/modify?from=Oauth");
//        }
    }
}
