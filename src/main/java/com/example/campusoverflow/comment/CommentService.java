package com.example.campusoverflow.comment;

import com.example.campusoverflow.comment.dto.CommentRequestNewDto;
import com.example.campusoverflow.comment.dto.CommentRequestUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository repository;
    private final CommentMapper mapper;

    public Comment save(CommentRequestNewDto requestDto) {
        Comment comment = mapper.toComment(requestDto);
        return repository.save(comment);
    }

    public Comment findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<Comment> findAll() {
        return repository.findAll();
    }

    public Iterable<Comment> findAllByQuestionId(Long questionId) {
        return repository.findAllByQuestionId(questionId);
    }

    public Iterable<Comment> findAllByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    public Comment update(CommentRequestUpdateDto requestDto) {
        Comment comment = mapper.toComment(requestDto);
        return repository.save(comment);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
