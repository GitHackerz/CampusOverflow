package com.example.campusoverflow.vote;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Iterable<Vote> findAllByAnswerId(Long answerId);

    Iterable<Vote> findAllByUserId(Long userId);

    Optional<Vote> findByUserIdAndAnswerId(Long userId, Long answerId);
}
