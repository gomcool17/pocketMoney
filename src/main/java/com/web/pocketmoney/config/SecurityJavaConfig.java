package com.web.pocketmoney.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .cors().disable().authorizeRequests()
                .antMatchers("/login", "/signup").permitAll()
                .and()
                .formLogin() // form을 통한 로그인 활성화
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureForwardUrl("/login") //login 살패 url설정
                .and()
                .logout()
                .logoutUrl("/login");// 로그아웃 url설정

    }

//    Bean을 생성하면 @Autowired를 통해 PasswordEncoder를 선언할때 자동으로 클래스가 바인딩 됨
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
