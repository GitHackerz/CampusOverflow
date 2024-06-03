package com.example.campusoverflow.vote;

import com.example.campusoverflow.answer.Answer;
import com.example.campusoverflow.common.BaseEntity;
import com.example.campusoverflow.user.User;
import com.example.campusoverflow.vote.enums.VoteType;
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
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"answer_id", "user_id"})
})
public class Vote extends BaseEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Answer answer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private User user;

    @Column(nullable = false)
    private VoteType type;
}
