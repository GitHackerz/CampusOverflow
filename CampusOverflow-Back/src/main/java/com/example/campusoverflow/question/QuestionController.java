package com.example.campusoverflow.question;

import com.example.campusoverflow.common.PageResponse;
import com.example.campusoverflow.question.dto.QuestionRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
@RequiredArgsConstructor
@Tag(name = "Question", description = "Question API")
public class QuestionController {

    private final QuestionService service;

    @GetMapping
    public ResponseEntity<PageResponse<Question>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(service.findAll(page, size));
    }

    @GetMapping("user")
    public ResponseEntity<PageResponse<Question>> findAllByUser(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Authentication authentication
    ) {
        return ResponseEntity.ok(service.findAllByUser(page, size, authentication));
    }

    @GetMapping("{id}")
    public ResponseEntity<Question> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("search")
    public ResponseEntity<PageResponse<Question>> search(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam String query
    ) {
        return ResponseEntity.ok(service.search(page, size, query));
    }

    @PostMapping
    public ResponseEntity<Question> save(
            @RequestBody @Valid QuestionRequest request,
            Authentication authentication
    ) {
        return ResponseEntity.ok(service.save(request, authentication));
    }

    @PutMapping
    public ResponseEntity<Question> update(@RequestBody Question question) {
        return ResponseEntity.ok(service.update(question));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id, Authentication authentication) {
        service.deleteById(id, authentication);
    }

}
