package com.web.pocketmoney.controller.board;

import com.web.pocketmoney.dto.board.CommentSaveDto;
import com.web.pocketmoney.entity.comment.Comment;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.model.CommonResult;
import com.web.pocketmoney.service.ResponseService;
import com.web.pocketmoney.service.board.CommentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.engine.CommentStructureHandler;

@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
@Log4j2
public class CommentController {
    private final CommentService commentService;
    private final ResponseService responseService;

    @ApiOperation(value = "댓글", notes = "댓글 작성을 함")
    @PostMapping("/{id}")
    public ResponseEntity<Comment> saveComment(@PathVariable("id") Long id, @RequestBody CommentSaveDto saveDto) {
        log.info("saveComment " + id + " " + saveDto.toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("현재 유저 : " + authentication.getName());
        //commentService.commentSave(saveDto, id);
        return ResponseEntity.ok(commentService.commentSave(saveDto,id));
    }

    @ApiOperation(value = "댓글",  notes = "댓글을 수정 함")
    @PutMapping("/{boardID}/{id}")
    public void putComment(@PathVariable("boardId") Long boardId, @PathVariable("id") Long commentId) {

    }
}
