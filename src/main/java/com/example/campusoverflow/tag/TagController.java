package com.example.campusoverflow.tag;

import com.example.campusoverflow.tag.dto.TagRequestNew;
import com.example.campusoverflow.tag.dto.TagRequestUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tag")
@RequiredArgsConstructor
@io.swagger.v3.oas.annotations.tags.Tag(name = "Tag", description = "Tag API")
public class TagController {

    private final TagService service;

    @GetMapping
    public List<Tag> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Tag findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping
    public Tag update(@RequestBody @Valid TagRequestUpdate tag) {
        return service.update(tag);
    }

    @GetMapping("name/{name}")
    public Tag findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("name/containing/{name}")
    public List<Tag> findByNameContaining(@PathVariable String name) {
        return service.findByNameContaining(name);
    }

    @PostMapping
    public Tag save(@RequestBody @Valid TagRequestNew tag) {
        return service.save(tag);
    }


}
