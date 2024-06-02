package com.example.campusoverflow.answer;

import com.example.campusoverflow.common.BaseEntity;
import com.example.campusoverflow.question.Question;
import com.example.campusoverflow.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Answer extends BaseEntity {

    @Column(nullable = false)
    private String content;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Question question;
}
