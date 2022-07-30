package com.web.pocketmoney.dto.user;

import com.web.pocketmoney.entity.role.UserRole;
import com.web.pocketmoney.entity.user.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private List<String> roleSet = new ArrayList<>();

    private String userName;

    private String password;

    private String sex;

    private String nickName;

    private int age;

    private String city;

    private Long kindScore;

//    private LocalDateTime regDate;

//    private LocalDateTime modDate;

    @Getter
    public static class Response implements Serializable {

        private final Long id;
        private final String userName;
        private final String nickName;
        private final String sex;
        private final int age;
        private final String city;
        private final Long kindScore;

        public Response(User user) {
            this.id = user.getId();
            this.userName = user.getUsername();
            this.sex = user.getSex();
            this.nickName = user.getNickName();
            this.age = user.getAge();
            this.city = user.getCity();
            this.kindScore = user.getKindScore();
        }
    }
}
