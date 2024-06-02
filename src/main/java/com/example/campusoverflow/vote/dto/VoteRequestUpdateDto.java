package com.example.campusoverflow.vote.dto;

import com.example.campusoverflow.vote.enums.VoteType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VoteRequestUpdateDto {

    @NotNull(message = "Vote id is required")
    private Long id;
    @NotNull(message = "Answer id is required")
    private Long answerId;
    @NotNull(message = "User id is required")
    private Long userId;
    @NotNull(message = "Type is required")
    @NotEmpty(message = "Type is required")
    private VoteType type;
}
