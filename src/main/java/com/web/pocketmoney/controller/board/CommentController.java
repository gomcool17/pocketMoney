package com.web.pocketmoney.controller.board;

import com.web.pocketmoney.dto.board.CommentSaveDto;
import com.web.pocketmoney.service.board.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.engine.CommentStructureHandler;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
@Log4j2
public class CommentController {
    private final CommentService commentService;

    @ApiOperation(value = "댓글", notes = "댓글 작성을 함")
    @PostMapping("/{id}")
    public void saveComment(@PathVariable("id") Long id, CommentSaveDto saveDto) {
        log.info("saveComment " + id + " " + saveDto.toString());
        commentService.commentSave(saveDto, id);
    }
}
