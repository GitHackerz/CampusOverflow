package com.example.campusoverflow.vote;

import com.example.campusoverflow.tag.TagService;
import com.example.campusoverflow.vote.dto.VoteRequestNewDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vote")
@RequiredArgsConstructor
public class VoteController {

    private final VoteService service;

    @PostMapping
    public ResponseEntity<Vote> saveVote(@RequestBody @Valid VoteRequestNewDto vote) {
        return ResponseEntity.ok(service.save(vote));
    }

    @DeleteMapping("{id}")
    public void deleteVoteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("answer/{answerId}")
    public ResponseEntity<Iterable<Vote>> findAllVotesByAnswerId(@PathVariable Long answerId) {
        return ResponseEntity.ok(service.findAllByAnswerId(answerId));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<Iterable<Vote>> findAllVotesByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }

    @GetMapping("{id}")
    public ResponseEntity<Vote> findVoteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


}
