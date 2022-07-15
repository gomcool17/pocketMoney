package com.web.pocketmoney.service.wish;

import com.web.pocketmoney.dto.wish.WishDTO;
import com.web.pocketmoney.dto.wish.WishPageRequestDTO;
import com.web.pocketmoney.dto.wish.WishPageResultDTO;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.wish.Wish;

import java.util.List;

public interface WishService {

    Long register(WishDTO wishDTO);

    void remove(Long id);

    WishPageResultDTO<WishDTO, Object[]> findAll(WishPageRequestDTO wishPageRequestDTO);

    default Wish dtoToEntity(WishDTO dto){

        User user = User.builder().id(dto.getUserId()).build();
        Board board = Board.builder().id(dto.getBoardId()).build();

        Wish wish = Wish.builder()
                .id(dto.getId())
                .userId(user)
                .boardId(board)
                .build();

        return wish;
    }

    default WishDTO entityToDTO(User user, Wish wish, Board board){

        WishDTO wishDTO = WishDTO.builder()
                .id(wish.getId())
                .userId(user.getId())
                .boardId(board.getId())
                .build();

        return wishDTO;
    }

}
