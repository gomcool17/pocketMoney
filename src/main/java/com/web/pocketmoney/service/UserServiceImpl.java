package com.web.pocketmoney.service;

import com.web.pocketmoney.config.security.JwtTokenProvider;
import com.web.pocketmoney.dto.user.LoginDTO;
import com.web.pocketmoney.dto.user.SignupUserDTO;
import com.web.pocketmoney.dto.user.TokenUserDTO;
import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.exception.CEmailSignupFailedException;
import com.web.pocketmoney.exception.CNickNameSignupFailedException;
import com.web.pocketmoney.exception.CSigninFailedException;
import com.web.pocketmoney.model.SingleResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider; // jwt 토큰 생성
    private final ResponseService responseService; // API 요청 결과에 대한 code, message
    private final PasswordEncoder encoder; // 비밀번호 암호화

    //회원 정보 조회
  /*  public UserDTO getUser(Long id){
        Object result = userRepository.getUserById(id);
        Object[] arr = (Object[])result;
        User entity = (User)arr[0];
        return entityToDto(entity);
    }

    @Override
    @Transactional
    public void modify(User user) {
        // 수정시에는 영속성 컨텍스트 User 오브젝트를 영속화시키고, 영속화된 User 오브젝트를 수정
        // select를 해서 User오브젝트를 db로 부터 가져오는 이유는 영속화를 하기 위해서
        // 영속화된 오브젝트를 변경하면 DB에 Update문을 날려주기 때문
        User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
            return new IllegalArgumentException("회원 찾기 실패");
        });
        //oauth에 값이 없으면 수정 가능
        //Validate 체크,OAuth로그인한 사람들은 비밀번호 변경 불가
        if(persistance.getOauth()==null || persistance.getOauth().equals("")){
            String rawPassword =  user.getPassword();
            String encPassword = encoder.encode(rawPassword);
            String nickName = user.getNickName();
            String sex = user.getSex();
            int age = user.getAge();
            String city = user.getCity();

            persistance.setPassword(encPassword);
            persistance.setNickName(nickName);
            persistance.setSex(sex);
            persistance.setAge(age);
            persistance.setCity(city);

            //회원 수정 함수 종료시 = 서비스 종료 = 트랜잭션 종료 = commit 자동
            //영속화된 persistance객체의 변화가 감지되면 더티체킹되어 update문을 날려준다.

        }
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    } */


    public SingleResult<TokenUserDTO> login(LoginDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        log.info("id : {}" , email);
        log.info("password : {}" , password);

        User user = userRepository.findByEmail(email).orElseThrow(CSigninFailedException::new);
        log.info(user.toString());
        if (!encoder.matches(password, user.getPassword())) {
            log.info("비밀번호 다름");
            // matches : 평문, 암호문 패스워드 비교 후 boolean 결과 return
            throw new CSigninFailedException();
        }
    /*    if(user.get() == false){
            throw new CEmailAuthTokenNotFoundException();
        }*/
        log.info("아아아아아아앙아");
        return responseService.getSingleResult(
                TokenUserDTO.builder()
                        .token(jwtTokenProvider.createToken(String.valueOf(user.getId()), user.getRoles()))
                        .userId(user.getId())
                        .nickName(user.getNickName())
                        .build()
        );
    }

    @Transactional
    public void signup(SignupUserDTO signupUserDTO) {
        log.info(signupUserDTO.toString());
        String email = signupUserDTO.getEmail();
        String nickName = signupUserDTO.getNickName();
        log.info(email + " " + nickName);
        User user1 = userRepository.findByEmail(email).orElse(null);
        User user2 = userRepository.findByNickName(nickName).orElse(null);
        if(user1 != null) {
            log.error(user1.toString());
            throw new CEmailSignupFailedException();
        }
        if(user2 != null) {
            throw new CNickNameSignupFailedException();
        }
        userRepository.save(User.builder()
                .userName(signupUserDTO.getUserName())
                .nickName(signupUserDTO.getNickName())
                .password(encoder.encode(signupUserDTO.getPassword()))
                .email(signupUserDTO.getEmail())
                .age(signupUserDTO.getAge())
                .city(signupUserDTO.getCity())
                .sex(signupUserDTO.getSex())
                .roles(Collections.singletonList("ROLE_USER"))
                .kindScore(0L)
                .build()
        );
    }
}
