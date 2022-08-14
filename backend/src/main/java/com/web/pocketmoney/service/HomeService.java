package com.web.pocketmoney.service;


import com.web.pocketmoney.dto.board.BoardHomeDto;
import com.web.pocketmoney.dto.board.BoardHomeResponserDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.vo.BoardListVo;
import com.web.pocketmoney.vo.CriteriaVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class HomeService {

    private final BoardRepository boardRepository;

    public BoardHomeResponserDto homeBoardList()
    {
        List<Board> boards = boardRepository.findAll();
        List<BoardListVo> boardVo = new ArrayList<>();

        for(Board b : boards) {
            boardVo.add(new BoardListVo(b.getId(), b.getTitle(),b.getView(), b.getCreateTime(), b.getUser().getNickName(), b.getPay(), b.getUser().getCity()));
        }

        Collections.sort(boardVo);
        int total = boardVo.size();
        CriteriaVo page = new CriteriaVo(1,9, total);

        List<BoardHomeDto> homeDto = new ArrayList<>();
        for(int i=page.getStart(); i <= page.getEnd(); i++) {
            homeDto.add(new BoardHomeDto(boardVo.get(i).getTitle(), boardVo.get(i).getPay(), boardVo.get(i).getCity()));
        }

        return new BoardHomeResponserDto(homeDto);
    }
}
