package com.example.campusoverflow.report.dto;

import com.example.campusoverflow.report.enums.ReportType;
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
public class ReportRequestNewDto {

    @NotNull(message = "Title is required")
    @NotEmpty(message = "Title is required")
    private String title;

    @NotNull(message = "Description is required")
    @NotEmpty(message = "Description is required")
    private String description;

    @NotNull(message = "Is resolved is required")
    private boolean isResolved;

    @NotNull(message = "Type is required")
    @Enumerated(EnumType.STRING)
    private ReportType type;

    private Long reportedUserId;
    private Long reportedAnswerId;
    private Long reportedQuestionId;

    @NotNull(message = "User is required")
    private Long userId;

}
