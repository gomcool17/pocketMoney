package com.web.pocketmoney.entity.board;

import com.web.pocketmoney.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Modifying // 뭔지 공부하자
    @Query("update Board b set b.view = b.view + 1 where b.id = :id")
    int updateView(@Param("id") Long id);

    Optional<Board> findById(Long id);
    List<Board> findByTitleContaining(String keyword);
   // Board findById(Long id);
   // Optional<Board> findById(Long boardId);
}
