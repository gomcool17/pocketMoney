package com.web.pocketmoney.controller.wish;


import com.web.pocketmoney.dto.user.ResponseDTO;
import com.web.pocketmoney.dto.wish.InsertWishDTO;
import com.web.pocketmoney.dto.wish.WishDTO;
import com.web.pocketmoney.dto.wish.WishPageRequestDTO;
import com.web.pocketmoney.dto.wish.WishPageResultDTO;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.response.DefaultRes;
import com.web.pocketmoney.response.StatusCode;
import com.web.pocketmoney.service.wish.WishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wish")
@Log4j2
@RequiredArgsConstructor
public class WishController {

    private final WishService wishService;

    @GetMapping("/list")
    public ResponseEntity<WishPageResultDTO> list(WishPageRequestDTO pageRequestDTO, Model model, @AuthenticationPrincipal User user){
        pageRequestDTO.setSize(9);
        WishPageResultDTO wishPageResultDTO = wishService.findAll(pageRequestDTO, user.getId());
//        if(!wishPageResultDTO.isPrev()){
//            return ResponseEntity.status(StatusCode.NOT_FOUND)
//                    .body(DefaultRes.res(StatusCode.NOT_FOUND, "아직 마음에 드는 구인글이 없습니다."));
//        }

//        model.addAttribute("result", wishPageResultDTO);
//        return ResponseEntity.ok()
//                .body(DefaultRes.res(StatusCode.OK, "관심 구인글 불러오기 완료!", wishPageResultDTO));
        return ResponseEntity.ok()
                .body(wishPageResultDTO);
    }


    @PostMapping("") //RequestMapping("/wish")
    public ResponseEntity<Void> register(@RequestBody InsertWishDTO insertWishDTO, @AuthenticationPrincipal User user){
        insertWishDTO.setUserId(user.getId());
        wishService.register(insertWishDTO);

//        return ResponseEntity.ok()
//                .body(DefaultRes.res(StatusCode.NO_CONTENT, "관심 구인글 등록 완료!"));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}") //RequestMapping("/wish")
    public ResponseEntity<DefaultRes> remove(@PathVariable("id")Long id, @AuthenticationPrincipal User user){
        wishService.remove(id, user.getId());

//        return ResponseEntity.ok()
//                .body(DefaultRes.res(StatusCode.NO_CONTENT, "관심 구인글 해제 완료!"));
        return ResponseEntity.noContent().build();
    }

}