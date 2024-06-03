package com.example.campusoverflow.vote.dto;

import com.example.campusoverflow.vote.enums.VoteType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VoteRequestNewDto {

    @NotNull(message = "Answer id is required")
    private Long answerId;
    @NotNull(message = "User id is required")
    private Long userId;
    @NotNull(message = "Type is required")
    @Enumerated(EnumType.STRING)
    private VoteType type;
}
