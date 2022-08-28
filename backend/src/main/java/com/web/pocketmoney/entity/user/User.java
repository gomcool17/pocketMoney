package com.web.pocketmoney.entity.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.web.pocketmoney.entity.base.BaseEntity;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.comment.Comment;
import com.web.pocketmoney.entity.image.Image;
import com.web.pocketmoney.entity.role.UserRole;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 10)
    private String sex;

    @Column(nullable = false, length = 10, unique = true)
    private String nickName;

    @Column(nullable = false)
    private int age;

    @Column(length = 10)
    private String city;

    @Column(nullable = false)
    private Long kindScore;

    private String oauth; // 카카오, 구글, 어디로 로그인 했는지

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>(); // 회원이 가지고 있는 권한 정보들

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Image> image = new ArrayList<>();
    //@CreationTimestamp // INSERT 시 자동으로 값을 채워줌
    //@Column(name = "created_at")
    //private Timestamp createTime;

   /* @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();*/


   // @OneToMany(mappedBy = "user")
   // @Column(name = "my_board_list")
   // private List<Board> boards = new ArrayList<>();
    //권한 부여 추가, 스프링 시큐리티
  /*  public void addUserRole(UserRole userRole){
        roleSet.add(userRole);
    }*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }

}
