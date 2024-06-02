package com.example.campusoverflow.answer;

import com.example.campusoverflow.answer.dto.AnswerRequestNewDto;
import com.example.campusoverflow.answer.dto.AnswerRequestUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("answer")
@RequiredArgsConstructor
public class AnswerController {

    private final AnswerService service;

    @GetMapping("question/{questionId}")
    public ResponseEntity<Iterable<Answer>> findAllByQuestionId(@PathVariable Long questionId) {
        return ResponseEntity.ok(service.findAllByQuestionId(questionId));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<Iterable<Answer>> findAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }

    @GetMapping("{id}")
    public ResponseEntity<Answer> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Answer> save(@RequestBody @Valid AnswerRequestNewDto answer) {
        return ResponseEntity.ok(service.save(answer));
    }

    @PatchMapping
    public ResponseEntity<Answer> update(@RequestBody @Valid AnswerRequestUpdateDto answer) {
        return ResponseEntity.ok(service.update(answer));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
