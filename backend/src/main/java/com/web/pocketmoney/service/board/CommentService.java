package com.web.pocketmoney.service.board;

import com.web.pocketmoney.dto.commet.CommentListDto;
import com.web.pocketmoney.dto.commet.CommentResponseSaveDto;
import com.web.pocketmoney.dto.commet.CommentSaveDto;
import com.web.pocketmoney.dto.commet.CommentUpdateDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.entity.comment.Comment;
import com.web.pocketmoney.entity.comment.CommentRepository;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.exception.CBoardIdFailedException;
import com.web.pocketmoney.exception.CCommentIdFindFailedException;
import com.web.pocketmoney.exception.CNotSameUserException;
import com.web.pocketmoney.exception.CUserNotFoundException;
import com.web.pocketmoney.vo.CriteriaVo;
import com.web.pocketmoney.vo.PageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public CommentResponseSaveDto commentSave(CommentSaveDto saveDto, Long id, User user) {
        log.info(saveDto.toString() + " " + id);
        Board board = boardRepository.findById(id).orElseThrow(CBoardIdFailedException::new);
        log.info(board.toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("현재 유저2 : " + authentication.getName());
        String email = authentication.getName();
        //User user = userRepository.findByEmail(email).orElseThrow(CUserNotFoundException::new);
        log.info(user.toString());
       commentRepository.save(Comment.builder()
                        .userId(user)
                        .boardId(board)
                        .text(saveDto.getText())
                        .build()
                );
       return CommentResponseSaveDto.builder()
               .text(saveDto.getText())
               .nickName(user.getNickName()).build();
    }

    @Transactional
    public CommentUpdateDto commentPut(Long boardId, Long commentId, CommentUpdateDto commentPutDto, User user) {
        String text = commentPutDto.getText();
        Comment comment = commentRepository.findById(commentId).orElseThrow(CCommentIdFindFailedException::new);
        log.info(comment.toString());
        comment.setText(text);
        log.info(comment);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("현재 유저2 : " + authentication.getName());
        String email = authentication.getName();
       // User user = userRepository.findByEmail(email).orElseThrow(CUserNotFoundException::new);
        log.info(user.toString());
        if(user.getId() != comment.getUserId().getId()) {
            throw new CNotSameUserException();
        }
        commentRepository.save(comment);
        return commentPutDto;
    }

    @Transactional
    public void commentDelete(Long commentId, User user) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(CCommentIdFindFailedException::new);
        if(comment.getUserId().getId() != user.getId()) {
            throw new CNotSameUserException();
        }
        commentRepository.delete(comment);
        return;
    }

    @Transactional
    public List<CommentListDto> commentList(Long id, int num)
    {
        List<CommentListDto> list = new ArrayList<>();
        Board boards = boardRepository.findById(id).orElseThrow(CBoardIdFailedException::new);
        List<Comment> comments = commentRepository.findAll(Sort.by(Sort.Direction.DESC, "creatTime"));
        int total = comments.size();
        PageVo page = new PageVo(new CriteriaVo(num, 10, total), total);


        for(int i=page.getCri().getStart(); i<=page.getCri().getEnd();i++) {
            list.add(new CommentListDto(comments.get(i).getId(), comments.get(i).getText(), comments.get(i).getUserId().getNickName(),comments.get(i).getCreateTime()));
        }
        return list;
    }
}
