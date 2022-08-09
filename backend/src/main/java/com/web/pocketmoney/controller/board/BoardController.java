package com.web.pocketmoney.controller.board;

import com.web.pocketmoney.dto.board.BoardSaveRequestDto;
import com.web.pocketmoney.dto.board.BoardSaveResponseDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private final BoardService boardService;

    @PostMapping("")
    public ResponseEntity<BoardSaveResponseDto> saveBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto, @AuthenticationPrincipal User user)
    {
        log.info("Board save Controller : " + user.toString());
        log.info(boardSaveRequestDto.toString());

        return ResponseEntity.ok(boardService.save(user, boardSaveRequestDto));
    }
}
