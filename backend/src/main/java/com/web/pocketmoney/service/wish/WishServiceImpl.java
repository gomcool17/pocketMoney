package com.web.pocketmoney.service.wish;

import com.web.pocketmoney.dto.wish.InsertWishDTO;
import com.web.pocketmoney.dto.wish.WishDTO;
import com.web.pocketmoney.dto.wish.WishPageRequestDTO;
import com.web.pocketmoney.dto.wish.WishPageResultDTO;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.board.BoardRepository;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.user.UserRepository;
import com.web.pocketmoney.entity.wish.Wish;
import com.web.pocketmoney.entity.wish.WishRepository;
import com.web.pocketmoney.exception.CBoardNotFoundException;
import com.web.pocketmoney.exception.CUserNotFoundException;
import com.web.pocketmoney.exception.CWishNotFoundException;
import com.web.pocketmoney.exception.CWishUserNotEqualCurrentException;
import com.web.pocketmoney.exception.handler.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class WishServiceImpl implements WishService{

    private final WishRepository wishRepository;
    private final UserRepository userRepository;

    private final BoardRepository boardRepository;


    @Override
    public Long register(InsertWishDTO insertwishDTO) {
        Board board = boardRepository.findById(insertwishDTO.getBoardId()).orElseThrow(()->
                new CBoardNotFoundException("해당 게시물을 찾을 수 없습니다.", ErrorCode.FORBIDDEN));

        Wish wish = dtoToEntity(insertwishDTO);
        log.info("wishDTO : " + insertwishDTO);
        log.info("wish : "+ wish);
        wishRepository.save(wish);
        return wish.getId();
    }

    @Override
    public void remove(Long id, Long userId) {



        Wish wish = wishRepository.findById(id)
                .orElseThrow(() -> new CWishNotFoundException(
                        "관심글이 존재하지 않습니다..", ErrorCode.FORBIDDEN
                ));

        log.info("wish : "+wish.getUserId().getId(), userId);
        if(!(wish.getUserId().getId().equals(userId))){
            throw new CWishUserNotEqualCurrentException("해당 관심글을 지울 수 있는 권한이 없습니다.", ErrorCode.FORBIDDEN);
        }
        wishRepository.deleteById(wish.getId());
    }

    @Override
    public WishPageResultDTO<WishDTO, Object[]> findAll(WishPageRequestDTO wishPageRequestDTO, Long id) {

        Pageable pageable = wishPageRequestDTO.getPageable(Sort.by("id").descending());

        log.info("pageable :: "+pageable+"id :: "+ id);

        Function<Object[], WishDTO> fn = (arr -> entityToDTO(
                (Wish) arr[0],
                (Board) arr[1],
                (User) arr[2]
        ));

        User user = userRepository.findById(id)
                .orElseThrow(() -> new CUserNotFoundException(
                        "존재하지 않는 유저입니다."
                ) );

        log.info("result : "+wishRepository.getListPage(pageable, user));
        Page<Object[]> result = wishRepository.getListPage(pageable, user);

        return new WishPageResultDTO<>(result, fn);
    }
}
