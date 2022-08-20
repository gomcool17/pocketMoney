package com.web.pocketmoney.service.user;

import com.web.pocketmoney.config.security.JwtTokenProvider;
import com.web.pocketmoney.dto.user.LoginDTO;
import com.web.pocketmoney.dto.user.SignupUserDTO;
import com.web.pocketmoney.dto.user.TokenUserDTO;
import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.exception.*;
import com.web.pocketmoney.exception.handler.ErrorCode;
import com.web.pocketmoney.model.SingleResult;
import com.web.pocketmoney.service.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider; // jwt 토큰 생성
    private final ResponseService responseService; // API 요청 결과에 대한 code, message
    private final PasswordEncoder encoder; // 비밀번호 암호화

    //회원 정보 조회
    public UserDTO getUser(Long id){
//        Object result = userRepository.findById(id);
//        Object[] arr = (Object[])result;
//        User entity = (User)arr[0];
//        log.info("user :: "+ entityToDto(entity));
//        return entityToDto(entity);
        log.info("userService :: "+ id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CUserNotFoundException(
                        "존재하지 않는 회원입니다.", ErrorCode.NOT_FOUND
                ));
        log.info("user :: "+user);
        return entityToDto(user);
//        return user.isPresent() ? entityToDto(user.get()) : null;
    }

    @Override
    @Transactional
    public void modify(UserDTO userDTO, User user) {
        // 수정시에는 영속성 컨텍스트 User 오브젝트를 영속화시키고, 영속화된 User 오브젝트를 수정
        // select를 해서 User오브젝트를 db로 부터 가져오는 이유는 영속화를 하기 위해서
        // 영속화된 오브젝트를 변경하면 DB에 Update문을 날려주기 때문
        log.info(userDTO.toString());

        User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
            return new CUserNotFoundException("수정할 수 없습니다.", ErrorCode.NOT_FOUND);
        });
        log.info(persistance.toString());
        //oauth에 값이 없으면 수정 가능
        //Validate 체크,OAuth로그인한 사람들은 비밀번호 변경 불가
        if(persistance.getOauth()==null || persistance.getOauth().equals("")){
            String rawPassword =  userDTO.getPassword();
            String encPassword = encoder.encode(rawPassword);
            String nickName = userDTO.getNickName();
            String sex = userDTO.getSex();
            int age = userDTO.getAge();
            String city = userDTO.getCity();

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
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CUserNotFoundException(
                        "존재하지 않는 회원입니다.", ErrorCode.NOT_FOUND
                ));
        log.info("not user ?" + user);
        userRepository.deleteById(user.getId());
//        userRepository.deleteById(user.getId());
        log.info("success delete !");
    }


    public SingleResult<TokenUserDTO> login(LoginDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        log.info("id : {}" , email);
        log.info("password : {}" , password);

        User user = userRepository.findByEmail(email).orElseThrow(CEmailSigninFailedException::new);
        log.info(user.toString());
        if (!encoder.matches(password, user.getPassword())) {
            log.info("비밀번호 다름");
            // matches : 평문, 암호문 패스워드 비교 후 boolean 결과 return
            throw new CPasswordSigninFailedException();
        }
    /*    if(user.get() == false){
            throw new CEmailAuthTokenNotFoundException();
        }*/
        log.info("아아아아아아앙아");
        return responseService.getSingleResult(
                TokenUserDTO.builder()
                        .token(jwtTokenProvider.createToken(String.valueOf(user.getEmail()), user.getRoles()))
                        .userId(user.getId())
                        .nickName(user.getNickName())
                        .build()
        );
    }

    @Transactional
    public SignupUserDTO signup(SignupUserDTO signupUserDTO) {
        log.info(signupUserDTO.toString());
        String email = signupUserDTO.getEmail();
        String nickName = signupUserDTO.getNickName();
        log.info(email + " " + nickName);
        User user1 = userRepository.findByEmail(email).orElse(null);
        User user2 = userRepository.findByNickName(nickName);
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
        return signupUserDTO;
    }
}
