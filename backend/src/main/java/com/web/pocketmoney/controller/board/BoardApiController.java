package com.web.pocketmoney.controller.board;


import com.web.pocketmoney.config.security.auth.LoginUser;
import com.web.pocketmoney.dto.board.BoardRequestDto;
import com.web.pocketmoney.dto.user.UserDTO;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.service.board.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Board Controller", tags = "Board")
@RequiredArgsConstructor
@RestController
public class BoardApiController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/board")
    @ApiOperation(value = "게시글 저장", notes = "게시글 저장 API")
    public ResponseEntity save(@RequestBody BoardRequestDto dto,
                               @LoginUser UserDTO.Response user) {
        return ResponseEntity.ok(boardService.save(dto, user.getNickName()));
    }

    @GetMapping("/boards")
    @ApiOperation(value = "게시글 목록", notes = "게시글 목록 조회 API")
    public List<Board> findLists() {
        return boardRepository.findAll();
    }

    @PutMapping("/board/{id}")
    @ApiOperation(value = "게시글 수정", notes = "게시글 수정 API")
    public ResponseEntity update(@PathVariable Long id, @RequestBody BoardRequestDto dto) {
        boardService.update(id, dto);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/board/{id}")
    @ApiOperation(value = "게시글 삭제", notes = "게시글 삭제 API")
    public ResponseEntity delete(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.ok(id);
    }
}
