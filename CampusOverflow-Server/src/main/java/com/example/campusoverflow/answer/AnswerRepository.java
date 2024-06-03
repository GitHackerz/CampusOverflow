package com.example.campusoverflow.answer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Iterable<Answer> findAllByQuestionId(Long questionId);

    Iterable<Answer> findAllByUserId(Long userId);
}
