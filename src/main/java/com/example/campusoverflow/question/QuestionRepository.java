package com.example.campusoverflow.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q WHERE q.user.id = :id")
    Page<Question> findAllByUserId(Long id, Pageable pageable);

    @Query("SELECT q FROM Question q WHERE q.title LIKE %:query% OR q.content LIKE %:query%")
    Page<Question> findAllByTitleAndContentContaining(@Param("query") String query, Pageable pageable);
}
