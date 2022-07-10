package com.web.pocketmoney.controller.board;

import com.web.pocketmoney.dto.board.BoardResponseDto;
import com.web.pocketmoney.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardIndexController {

    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    /* 글 작성 */
    @GetMapping("/board/write")
    public String write(Model model) {
        return "board/write";
    }

    /* 글 상세 보기 */
    @GetMapping("/board/read/{id}")
    public String read(@PathVariable Long id, Model model) {
        BoardResponseDto dto = boardService.findById(id);
        boardService.updateViewCount(id);
        model.addAttribute("board", dto);
        return "board/read";
    }

    /* 글 수정 */
    @GetMapping("/board/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);
        return "board/update";
    }

}

