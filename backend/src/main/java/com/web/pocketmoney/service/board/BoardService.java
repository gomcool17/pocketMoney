package com.web.pocketmoney.service.board;

import com.web.pocketmoney.dto.board.BoardRequestDto;
import com.web.pocketmoney.dto.board.BoardResponseDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(BoardRequestDto dto, String nickname) {

        /* User 정보를 가져와 dto에 담아주기 */
        User user = userRepository.findByNickName(nickname);
        dto.setUser(user);

        log.info("Post Service - save() 실행");

        Board board = dto.toEntity();
        boardRepository.save(board);

        return board.getId();
    }

    @Transactional
    public BoardResponseDto findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id: " + id));
        return new BoardResponseDto(board);
    }

    @Transactional
    public void update(Long id, BoardRequestDto dto) {
        Board board = boardRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        board.update(dto.getTitle(), dto.getContent(), dto.getArea(), dto.getWantedTime(), dto.getDayOfWeek(), dto.getPay());
    }

    @Transactional
    public void delete(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(()
        -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id=" + id));

        boardRepository.delete(board);
    }

    @Transactional
    public int updateViewCount(Long id) {
        return boardRepository.updateView(id);
    }

    @Transactional
    public Page<Board> pageList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional
    public List<Board> search(String keyword) {
        List<Board> searchList = boardRepository.findByTitleContaining(keyword);
        return searchList;
    }
}
