package com.example.campusoverflow.comment;

import com.example.campusoverflow.comment.dto.CommentRequestNewDto;
import com.example.campusoverflow.comment.dto.CommentRequestUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    @GetMapping
    public Iterable<Comment> findAll() {
        return service.findAll();
    }

    @GetMapping("question/{questionId}")
    public Iterable<Comment> findAllByQuestionId(@PathVariable Long questionId) {
        return service.findAllByQuestionId(questionId);
    }

    @GetMapping("user/{userId}")
    public Iterable<Comment> findAllByUserId(@PathVariable Long userId) {
        return service.findAllByUserId(userId);
    }

    @GetMapping("{id}")
    public Comment findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Comment save(@RequestBody @Valid CommentRequestNewDto comment) {
        return service.save(comment);
    }

    @PutMapping
    public Comment update(@RequestBody @Valid CommentRequestUpdateDto comment) {
        return service.update(comment);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
