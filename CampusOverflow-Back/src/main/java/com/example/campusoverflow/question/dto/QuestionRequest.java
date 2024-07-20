package com.example.campusoverflow.question.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuestionRequest {

    @NotEmpty(message = "Title cannot be empty")
    @NotNull(message = "Title cannot be null")
    private String title;

    @NotEmpty(message = "Content cannot be empty")
    @NotNull(message = "Content cannot be null")
    private String content;

    @NotEmpty(message = "Tags cannot be empty")
    @NotNull(message = "Tags cannot be null")
    private List<Long> tags;
}
