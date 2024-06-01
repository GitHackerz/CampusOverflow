package com.example.campusoverflow.tag;

import com.example.campusoverflow.exceptions.AlreadyExistsException;
import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.tag.dto.TagRequestNew;
import com.example.campusoverflow.tag.dto.TagRequestUpdate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TagService {

    private final TagRepository repository;
    private final TagMapper tagMapper;

    public Tag save(TagRequestNew request) {
        Tag tag = tagMapper.toTag(request);
        if (repository.findByName(tag.getName()).isPresent())
            throw new AlreadyExistsException("Tag with name " + tag.getName() + " already exists");
        return repository.save(tag);
    }

    public List<Tag> findAll() {
        return repository.findAll();
    }

    public Tag findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Tag with id " + id + " not found"));
    }

    public void deleteById(Long id) {
        if (repository.findById(id).isEmpty()) {
            throw new NotFoundException("Tag with id " + id + " not found");
        }
        repository.deleteById(id);
    }

    public Tag update(TagRequestUpdate request) {
        Tag tag = tagMapper.toTag(request);
        if (repository.findById(tag.getId()).isEmpty()) {
            throw new NotFoundException("Tag with id " + tag.getId() + " not found");
        }
        return repository.save(tag);
    }

    public Tag findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new NotFoundException("Tag with name " + name + " not found"));
    }

    public List<Tag> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }
}
