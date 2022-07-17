package com.web.pocketmoney.service.wish;

import com.web.pocketmoney.dto.wish.WishDTO;
import com.web.pocketmoney.dto.wish.WishPageRequestDTO;
import com.web.pocketmoney.dto.wish.WishPageResultDTO;
import com.web.pocketmoney.entity.board.Board;
import com.web.pocketmoney.entity.user.User;
import com.web.pocketmoney.entity.wish.Wish;
import com.web.pocketmoney.entity.wish.WishRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class WishServiceImpl implements WishService{

    private final WishRepository wishRepository;


    @Override
    public Long register(WishDTO wishDTO) {

        Wish wish = dtoToEntity(wishDTO);

        wishRepository.save(wish);
        return wish.getId();
    }

    @Override
    public void remove(Long id) {
        wishRepository.deleteById(id);
    }

    @Override
    public WishPageResultDTO<WishDTO, Object[]> findAll(WishPageRequestDTO wishPageRequestDTO) {

        Pageable pageable = wishPageRequestDTO.getPageable(Sort.by("id").descending());

        Function<Object[], WishDTO> fn = (arr -> entityToDTO(
                (Wish) arr[0],
                (Board) arr[1],
                (User) arr[2]
        ));

        Page<Object[]> result = wishRepository.getListPage(pageable);

        return new WishPageResultDTO<>(result, fn);
    }
}
