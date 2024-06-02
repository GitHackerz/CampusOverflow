package com.example.campusoverflow.tag;

import com.example.campusoverflow.tag.dto.TagRequestNew;
import com.example.campusoverflow.tag.dto.TagRequestUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tag")
@RequiredArgsConstructor
@io.swagger.v3.oas.annotations.tags.Tag(name = "Tag", description = "Tag API")
public class TagController {

    private final TagService service;

    @GetMapping
    public ResponseEntity<List<Tag>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Tag> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Tag> findByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("name/containing/{name}")
    public ResponseEntity<List<Tag>> findByNameContaining(@PathVariable String name) {
        return ResponseEntity.ok(service.findByNameContaining(name));
    }

    @PostMapping
    public ResponseEntity<Tag> save(@RequestBody @Valid TagRequestNew tag) {
        return ResponseEntity.ok(service.save(tag));
    }

    @PutMapping
    public ResponseEntity<Tag> update(@RequestBody @Valid TagRequestUpdate tag) {
        return ResponseEntity.ok(service.update(tag));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }


}
