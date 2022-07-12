package com.web.pocketmoney.service.board;

import com.web.pocketmoney.dto.board.CommentSaveDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.entity.comment.Comment;
import com.web.pocketmoney.entity.comment.CommentRepository;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.exception.CBoardIndFailedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentService {

    private CommentRepository commentRepository;
    private BoardRepository boardRepository;
    private UserRepository userRepository;

    public void commentSave(CommentSaveDto saveDto, Long id) {
        log.info(saveDto.toString() + " " + id);
        Board board = boardRepository.findById(id).orElseThrow(CBoardIndFailedException::new);
        log.info("커멘드세이브가 왜 안될까유");
       // User user = userRepository.findById(board.getId()).orElseThrow();
        log.info("찾은 게시글 : " + board.toString());
        User user = (User)SecurityContextHolder.getContext().getAuthentication();
        log.info("로그인 중인 유저 : " + user.toString());
        commentRepository.save(Comment.builder()
                        .userId(user)
                        .boardId(board)
                        .text(saveDto.getText())
                        .build()
                );
        return;
    }
}
