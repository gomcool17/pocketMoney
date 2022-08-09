package com.web.pocketmoney.service.board;

import com.web.pocketmoney.dto.board.BoardSaveRequestDto;
import com.web.pocketmoney.dto.board.BoardSaveResponseDto;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.entity.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardSaveResponseDto save(User user, BoardSaveRequestDto dto)
    {
        log.info(1);
        int[] date = dto.getDate();
        log.info(2);
        LocalDateTime dateTime = LocalDateTime.of(date[0], date[1], date[2], date[3], date[4], 0,0);
        log.info(3);
        boardRepository.save(Board.builder()
                        .area(dto.getArea())
                        .content(dto.getContent())
                        .dayOfWeek(dto.getDayOfWeek())
                        .user(user)
                        .title(dto.getTitle())
                        .pay(dto.getPay())
                        .wantedTime(dateTime)
                .build()
        );

        return BoardSaveResponseDto.builder()
                .nickName(user.getNickName())
                .area(dto.getArea())
                .pay(dto.getPay())
                .dayOfWeek(dto.getDayOfWeek())
                .title(dto.getTitle())
                .content(dto.getContent())
                .date(dto.getDate())
                .build();
    }
}
