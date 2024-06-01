package com.example.campusoverflow.question;

import com.example.campusoverflow.question.dto.QuestionRequest;
import org.springframework.stereotype.Service;

@Service
public class QuestionMapper {

    public Question toQuestion(QuestionRequest request) {
        return Question.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .tags(request.getTags())
                .build();
    }

}
