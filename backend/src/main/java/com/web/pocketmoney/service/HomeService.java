package com.web.pocketmoney.service;


import com.web.pocketmoney.dto.board.BoardHomeDto;
import com.web.pocketmoney.dto.board.BoardHomeResponserDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.vo.CriteriaVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class HomeService {

    private final BoardRepository boardRepository;

    public BoardHomeResponserDto homeBoardList()
    {
        List<Board> boards = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createTime"));

        int total = boards.size();
        CriteriaVo page = new CriteriaVo(1,9, total);

        List<BoardHomeDto> homeDto = new ArrayList<>();
        for(int i=page.getStart(); i <= page.getEnd(); i++) {
            homeDto.add(new BoardHomeDto(boards.get(i).getTitle(), boards.get(i).getPay(), boards.get(i).getUser().getCity()));
        }

        return new BoardHomeResponserDto(homeDto);
    }
}
