package com.web.pocketmoney.controller.board;

import com.web.pocketmoney.config.security.auth.LoginUser;
import com.web.pocketmoney.dto.board.BoardResponseDto;
import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardIndexController {

    private final BoardService boardService;

    /* 글 전체 목록 조회 */
    @GetMapping("/")
    public String index(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
            Page<Board> list = boardService.pageList(pageable);

            model.addAttribute("boards", boardService.pageList(pageable));
            model.addAttribute("previous", pageable.previousOrFirst().getPageNumber()); //이전 페이지
            model.addAttribute("next", pageable.next().getPageNumber()); // 다음 페이지
            model.addAttribute("hasNext", list.hasNext()); // 이전, 다음 페이지 유무에 따른 T, F 반환
            model.addAttribute("hasPrev", list.hasPrevious());
            return "boards";
    }

    /* 글 상세 보기 */
    @GetMapping("/board/read/{id}")
    public String read(@PathVariable Long id, @LoginUser UserDTO.Response user, Model model) {
        BoardResponseDto dto = boardService.findById(id);

        if (user != null) {
            model.addAttribute("user", user.getNickName());

            /* 게시글 작성자 본인인지 확인 */
            if (dto.getId().equals(user.getId())) {
                model.addAttribute("writer", true);
            }
        }

        boardService.updateViewCount(id);
        model.addAttribute("board", dto);
        return "board/read";
    }

    /* 검색 후 조회 */
    @GetMapping("/board/search")
    public String search(String keyword, Model model) {
        List<Board> searchList = boardService.search(keyword);
        model.addAttribute("searchList", searchList);
        return "board-search";
    }

    /* 글 작성 */
    @GetMapping("/board/write")
    public String write(@LoginUser UserDTO.Response user, Model model) {
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "board/write";
    }

    /* 글 수정 */
    @GetMapping("/board/update/{id}")
    public String update(@PathVariable Long id, @LoginUser UserDTO.Response user, Model model) {
        BoardResponseDto dto = boardService.findById(id);
        if (user != null) {
            model.addAttribute("user", user);
        }
        model.addAttribute("board", dto);
        return "board/update";
    }
}

