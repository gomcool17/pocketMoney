package com.web.pocketmoney.controller.board;

import com.web.pocketmoney.dto.commet.CommentSaveDto;
import com.web.pocketmoney.dto.commet.CommentUpdateDto;
import com.web.pocketmoney.entity.comment.Comment;
import com.web.pocketmoney.service.ResponseService;
import com.web.pocketmoney.service.board.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        //commentService.commentSave(saveDto, id);
        return ResponseEntity.ok(commentService.commentSave(saveDto,id));
    }

    @ApiOperation(value = "댓글",  notes = "댓글을 수정 함")
    @PutMapping("/{boardId}/{id}")
    public ResponseEntity<Comment> putComment(@PathVariable("boardId") Long boardId, @PathVariable("id") Long commentId, @RequestBody CommentUpdateDto dto) {
        log.info("putComment :" + boardId + " " + commentId);
        return ResponseEntity.ok(commentService.commentPut(boardId, commentId, dto));
    }

    @ApiOperation(value = "댓글", notes = "댓글을 삭제 함")
    @DeleteMapping("/{boardId}/{id}")
    public void deleteComment(@PathVariable("id") Long id) {
        commentService.commentDelete(id);
        return;
    }
}
