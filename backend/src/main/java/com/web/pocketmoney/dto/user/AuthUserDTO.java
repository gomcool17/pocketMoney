package com.web.pocketmoney.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Log4j2
@Getter
@Setter
@ToString
public class AuthUserDTO extends User {

    private String email;

    private String name;

    private String password;
    private String OAuth;

    public AuthUserDTO(String username,
                       String password,
                       String OAuth,
                       Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.password = password;
        this.OAuth = OAuth;
    }
}
