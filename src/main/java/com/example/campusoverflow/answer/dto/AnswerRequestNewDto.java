package com.example.campusoverflow.answer.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnswerRequestNewDto {

    @NotEmpty(message = "Content is required")
    @NotNull(message = "Content is required")
    private String content;

    @NotNull(message = "User id is required")
    private Long userId;

    @NotNull(message = "Question id is required")
    private Long questionId;
}
