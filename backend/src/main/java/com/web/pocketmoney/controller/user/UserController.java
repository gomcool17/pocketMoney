package com.web.pocketmoney.controller.user;

import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.exception.CUserNotFoundException;
import com.web.pocketmoney.exception.ChatRoomNotFoundException;
import com.web.pocketmoney.exception.handler.ErrorCode;
import com.web.pocketmoney.exception.handler.ErrorResponse;
import com.web.pocketmoney.exception.handler.GlobalExceptionHandler;
import com.web.pocketmoney.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @GetMapping("") //RequestMapping("/user")
    public ResponseEntity<UserDTO> readOne(Model model, @AuthenticationPrincipal User user){


//        log.info("controller :: "+ id);

        UserDTO userDTO = userService.getUser(user.getId());
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
    @PutMapping("") //RequestMapping("/user")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @AuthenticationPrincipal User user){

        log.info("userDTOss : " + userDTO.getId());
        log.info("user.getID : " + user.getId());
        log.info("bool : " + userDTO.getId().equals(user.getId()));
        if (!(userDTO.getId().equals(user.getId()))) {
            log.info("different");
            throw new CUserNotFoundException("권한이 없습니다.", ErrorCode.FORBIDDEN);
        }else{
            //RequestBody가 없을 경우, Json을 못 받는다. key=value로만 받을 수 있다.
            userService.modify(userDTO, user);

            log.info("whyyyy");
            //세션 등록
            //어썬티케이션 매니저에게 유저네임과 패스워드를 던져서
            //매니저가 자동으로 세션등록 해준다.
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("gostarrrttt");

//        return ResponseEntity.ok()
//                .body(DefaultRes.res(StatusCode.NO_CONTENT, "회원정보 수정 완료!"));
            return ResponseEntity.ok().build();
        }


    }

    @DeleteMapping("") //RequestMapping("/user")
    public ResponseEntity<Void> delete(@AuthenticationPrincipal User user){
//        User user = userService.DtoToEntity(userService.getUser(id));
        userService.delete(user.getId());

//        return ResponseEntity.ok()
//                .body(DefaultRes.res(StatusCode.NO_CONTENT, "회원정보 삭제 완료!"));
        return ResponseEntity.noContent().build();
    }
}