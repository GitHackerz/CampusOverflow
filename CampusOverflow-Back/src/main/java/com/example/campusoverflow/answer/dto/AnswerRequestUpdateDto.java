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
public class AnswerRequestUpdateDto {

    @NotNull(message = "Id is required")
    private Long id;

    @NotEmpty(message = "Content is required")
    @NotNull(message = "Content is required")
    private String content;
}
