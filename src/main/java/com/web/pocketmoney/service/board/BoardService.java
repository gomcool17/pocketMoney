package com.web.pocketmoney.service.board;

import com.web.pocketmoney.dto.board.BoardResponseDto;
import com.web.pocketmoney.dto.board.BoardSaveRequestDto;
import com.web.pocketmoney.dto.board.BoardUpdateRequestDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardResponseDto save(BoardSaveRequestDto requestDto) {
        return new BoardResponseDto(boardRepository.save(requestDto.toEntity()));
    }

    @Transactional
    public BoardResponseDto findById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardResponseDto update(Long id, BoardUpdateRequestDto requestDto) {
        Board findBoard = boardRepository.findById(id).orElseThrow();
        findBoard.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getArea(), requestDto.getWantedTime(),
                requestDto.getDayOfWeek(), requestDto.getPay(), requestDto.getViewCount(), requestDto.getLikes());
        return new BoardResponseDto(findBoard);
    }

    @Transactional
    public void delete(Long id) {
        Board findBoard = boardRepository.findById(id).orElseThrow();
        boardRepository.delete(findBoard);
    }

    @Transactional
    public int updateViewCount(Long id) {
        return boardRepository.updateViewCount(id);
    }
}
