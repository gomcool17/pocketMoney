package com.web.pocketmoney.entity.comment;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Modifying
    @Query("update Comment c set c.text = :text where c.id = :id")
    String updateText(@Param("text") String text, @Param("id") Long id);

   // List<Comment> findAll(Sort.Direction desc, Long id);
}
