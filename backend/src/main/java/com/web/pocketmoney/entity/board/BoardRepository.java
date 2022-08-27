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

    @Modifying
    @Query("select b from Board b where b.title like %:search% order by b.createTime desc")
    List<Board> searchBoards(@Param("search") String search);

    @Modifying
    @Query("select b from Board b where b.area like %:search% order by b.createTime desc")
    List<Board> searchBoardByArea(@Param("search") String search);
    /*@Query("SELECT u.username FROM User u WHERE u.username LIKE CONCAT('%',:username,'%')")
    List<String> findUsersWithPartOfName(@Param("username") String username);*/

    List<Board> findByTitleLike(String title);

    Optional<Board> findById(Long id);
    List<Board> findByTitleContaining(String keyword);
   // Board findById(Long id);
   // Optional<Board> findById(Long boardId);
}
