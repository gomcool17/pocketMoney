package com.web.pocketmoney.dto.user;

import com.web.pocketmoney.entity.role.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private Set<UserRole> roleSet = new HashSet<>();

    private String username;

    private String password;

    private String sex;

    private String nickname;

    private int age;

    private String city;

    private Long kindScore;

    private LocalDateTime regDate;

    private LocalDateTime modDate;


}
