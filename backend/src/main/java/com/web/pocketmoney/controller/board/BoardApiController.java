package com.web.pocketmoney.controller.board;


import com.web.pocketmoney.dto.board.BoardResponseDto;
import com.web.pocketmoney.dto.board.BoardSaveRequestDto;
import com.web.pocketmoney.dto.board.BoardUpdateRequestDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.service.board.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Board Controller", tags = "Board")
@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("/board")
    public BoardResponseDto save(@RequestBody BoardSaveRequestDto requestDto) {
        BoardResponseDto board = boardService.save(requestDto);
        return board;
    }

    @GetMapping("/boards")
    public List<Board> findLists() {
        return boardRepository.findAll();
    }

    @PutMapping("/board/{id}")
    public BoardResponseDto update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/board/{id}")
    public Long delete(@PathVariable Long id) {
        boardService.delete(id);
        return id;
    }

}
