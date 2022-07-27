package com.web.pocketmoney.controller.user;

import com.web.pocketmoney.dto.user.ResponseDTO;
import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.response.DefaultRes;
import com.web.pocketmoney.response.ResponseMessage;
import com.web.pocketmoney.response.StatusCode;
import com.web.pocketmoney.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Log4j2
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    //회원 정보 조회
    @GetMapping("/myPage/{id}")
    public ResponseEntity<UserDTO> readOne(@PathVariable("id") Long id, Model model){

        log.info("controller :: "+ id);

        UserDTO userDTO = userService.getUser(id);
        log.info("userDTO :: "+userDTO);
//        model.addAttribute("dto", userDTO);
//        if(userDTO == null){
//            return ResponseEntity
//                    .status(StatusCode.NOT_FOUND)
//                    .body(new DefaultRes(StatusCode.NOT_FOUND, "일치하는 회원을 찾을 수 없습니다. 사용자 id를 확인하세요"));
//        }
//        return ResponseEntity
//                .ok()
//                .body(new DefaultRes(StatusCode.OK, "회원정보 불러오기 완료!", userDTO));
        return ResponseEntity.ok()
                .body(userDTO);
    }

    //회원 수정
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO){
        //RequestBody가 없을 경우, Json을 못 받는다. key=value로만 받을 수 있다.
        userService.modify(userDTO);

        //세션 등록
        //어썬티케이션 매니저에게 유저네임과 패스워드를 던져서
        //매니저가 자동으로 세션등록 해준다.
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUserName(),userDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

//        return ResponseEntity.ok()
//                .body(DefaultRes.res(StatusCode.NO_CONTENT, "회원정보 수정 완료!"));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
//        User user = userService.DtoToEntity(userService.getUser(id));
        userService.delete(id);

//        return ResponseEntity.ok()
//                .body(DefaultRes.res(StatusCode.NO_CONTENT, "회원정보 삭제 완료!"));
        return ResponseEntity.noContent().build();
    }
}