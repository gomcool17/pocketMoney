package com.web.pocketmoney.controller;

import com.web.pocketmoney.dto.board.BoardHomeResponserDto;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.service.HomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class HomeController {
    private final BoardRepository boardRepository;
    private final HomeService homeService;
    @GetMapping("/")
    public ResponseEntity<BoardHomeResponserDto> homeBoardList() {

        return ResponseEntity.ok(homeService.homeBoardList());
   }
}
