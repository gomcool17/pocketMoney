package com.web.pocketmoney.controller;

import com.web.pocketmoney.dto.board.BoardHomeDto;
import com.web.pocketmoney.dto.board.BoardHomeResponserDto;
import com.web.pocketmoney.dto.board.BoardListDto;
import com.web.pocketmoney.dto.board.BoardResponseListDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.service.HomeService;
import com.web.pocketmoney.vo.BoardListVo;
import com.web.pocketmoney.vo.CriteriaVo;
import com.web.pocketmoney.vo.PageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
