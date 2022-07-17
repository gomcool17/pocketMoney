package com.web.pocketmoney.entity.wish;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WishRepository extends JpaRepository<Wish, Long> {

    // 내 관심 구인글 목록 + 게시판 제목 같이 가져오기
    @Query("select w, b.title" +
            " from Wish w left join Board b on b.id = w" +
            " where w.userId = : userId")
    Object getWishByUserId(@Param("userId") Long userId);

    @Query("select w, b.title, u.email " +
            " from Wish w left join Board b on b.id = w" +
            " left join User u" +
            " where w.userId = : userId")
    Page<Object[]> getListPage(Pageable pageable);

//    @Query("select w, b.title, u.email " +
//            " from Wish w" +
//            " left join Board b on b.id = w" +
//            " left join User u on u.id = w.writeId" +
//            " where w.userId = : userId")
//    Page<Object[]> getListPage(Pageable pageable);

}
