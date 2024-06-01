package com.example.campusoverflow.tag.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TagRequestNew {

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;
}
