package com.example.campusoverflow.report;

import com.example.campusoverflow.answer.Answer;
import com.example.campusoverflow.common.BaseEntity;
import com.example.campusoverflow.question.Question;
import com.example.campusoverflow.report.enums.ReportType;
import com.example.campusoverflow.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Report extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean isResolved;

    @Column(nullable = false)
    private ReportType type;

    @ManyToOne(cascade = CascadeType.ALL)
    private User reportedUser;

    @ManyToOne(cascade = CascadeType.ALL)
    private Answer reportedAnswer;

    @ManyToOne(cascade = CascadeType.ALL)
    private Question reportedQuestion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private User user;
}
