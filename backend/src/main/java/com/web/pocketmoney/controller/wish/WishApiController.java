package com.web.pocketmoney.controller.wish;


import com.web.pocketmoney.dto.user.ResponseDTO;
import com.web.pocketmoney.dto.wish.WishDTO;
import com.web.pocketmoney.service.wish.WishService;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wish")
@Log4j2
@RequiredArgsConstructor
public class WishApiController {

    private final WishService wishService;

    @PostMapping("")
    public ResponseDTO<Integer> register(@RequestBody WishDTO wishDTO){
        wishService.register(wishDTO);

        return new ResponseDTO<>(HttpStatus.OK.value(),  1);

    }

    @DeleteMapping("/{id}")
    public ResponseDTO<Integer> remove(@PathVariable("id") Long id ){
        wishService.remove(id);

        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1);
    }

}
