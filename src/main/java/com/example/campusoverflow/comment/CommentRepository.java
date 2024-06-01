package com.example.campusoverflow.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Iterable<Comment> findAllByQuestionId(Long questionId);

    Iterable<Comment> findAllByUserId(Long userId);
}
