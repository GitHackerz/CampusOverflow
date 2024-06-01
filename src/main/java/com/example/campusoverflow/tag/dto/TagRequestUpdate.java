package com.example.campusoverflow.tag.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TagRequestUpdate {

    @NotNull(message = "Id is required")
    private Long id;

    @NotNull(message = "Name is required")
    @NotEmpty(message = "Name is required")
    private String name;
}
