package com.example.campusoverflow.question;

import com.example.campusoverflow.question.dto.QuestionRequest;
import com.example.campusoverflow.tag.Tag;
import com.example.campusoverflow.tag.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionMapper {

    private final TagRepository tagRepository;

    public Question toQuestion(QuestionRequest request) {
        List<Tag> tags = new ArrayList<>();

        request.getTags().forEach(tagId -> {
            Tag tag = tagRepository.findById(tagId)
                    .orElseThrow(() -> new IllegalArgumentException("Tag not found"));
            tags.add(tag);
        });

        return Question.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .tags(tags)
                .build();
    }

}
