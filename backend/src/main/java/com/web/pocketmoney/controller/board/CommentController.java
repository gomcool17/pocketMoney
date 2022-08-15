package com.web.pocketmoney.controller.board;

import com.web.pocketmoney.dto.commet.*;
import com.web.pocketmoney.entity.comment.Comment;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.service.ResponseService;
import com.web.pocketmoney.service.board.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
@RequiredArgsConstructor
@Log4j2
public class CommentController {
    private final CommentService commentService;
    private final ResponseService responseService;

    @ApiOperation(value = "댓글", notes = "댓글 작성을 함")
    @PostMapping("/{id}")
    public ResponseEntity<CommentResponseSaveDto> saveComment(@AuthenticationPrincipal User user, @PathVariable("id") Long id, @RequestBody CommentSaveDto saveDto) {
        log.info("saveComment " + id + " " + saveDto.toString());
        log.info("user : " + user.toString());
        //commentService.commentSave(saveDto, id);
        return ResponseEntity.ok(commentService.commentSave(saveDto,id, user));
    }

    @ApiOperation(value = "댓글",  notes = "댓글을 수정 함")
    @PutMapping("/{boardId}/{id}")
    public ResponseEntity<CommentUpdateDto> putComment(@AuthenticationPrincipal User user, @PathVariable("boardId") Long boardId, @PathVariable("id") Long commentId, @RequestBody CommentUpdateDto dto) {
        log.info("putComment :" + boardId + " " + commentId);
        return ResponseEntity.ok(commentService.commentPut(boardId, commentId, dto, user));
    }

    @ApiOperation(value = "댓글", notes = "댓글을 삭제 함")
    @DeleteMapping("/{boardId}/{id}")
    public void deleteComment(@AuthenticationPrincipal User user, @PathVariable("id") Long id, @PathVariable("boardId") Long boardId) {
        commentService.commentDelete(id, user, boardId);
        return;
    }

    @GetMapping("/{boardId}/{num}")
    public ResponseEntity<CommentResponseListDto> commentList(@PathVariable("boardId") Long id, @PathVariable("num") int num)
    {
        return ResponseEntity.ok(commentService.commentList(id, num));
    }
}
