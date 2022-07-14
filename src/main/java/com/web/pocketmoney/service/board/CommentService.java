package com.web.pocketmoney.service.board;

import com.web.pocketmoney.dto.board.CommentSaveDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.entity.comment.Comment;
import com.web.pocketmoney.entity.comment.CommentRepository;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.exception.CBoardIndFailedException;
import com.web.pocketmoney.exception.CUserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public Comment commentSave(CommentSaveDto saveDto, Long id) {
        log.info(saveDto.toString() + " " + id);
        Board board = boardRepository.findById(id).orElseThrow(CBoardIndFailedException::new);
       // List<Board> bb = boardRepository.findAll();
       // System.out.println("bb = " + bb);
//        for (Board board : bb) {
//            log.info("bb : "+board.toString());
//        }
        log.info(board.toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("현재 유저2 : " + authentication.getName());
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow(CUserNotFoundException::new);
        log.info(user.toString());
       // User user = userRepository.findById(board.getId()).orElseThrow();
       // log.info("찾은 게시글 : " + board.toString());
       // User user = (User)SecurityContextHolder.getContext().getAuthentication();
       // log.info("로그인 중인 유저 : " + user.toString());
        return commentRepository.save(Comment.builder()
                        .userId(user)
                        .boardId(board)
                        .text(saveDto.getText())
                        .build()
                );
        //return;
    }
}
