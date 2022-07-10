package com.web.pocketmoney.dto.user;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;

@Data
public class SignupUserDTO {
    private String userName;
    private String email;
    private String password;
    private String sex;
    private String nickName;
    private int age;
    private String city;
    private List<String> roles = new ArrayList<>();
}
