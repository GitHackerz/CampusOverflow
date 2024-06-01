package com.example.campusoverflow.question;

import com.example.campusoverflow.common.BaseEntity;
import com.example.campusoverflow.tag.Tag;
import com.example.campusoverflow.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question extends BaseEntity {

    private String title;
    private String content;
    @ManyToMany
    @JoinTable(
            name = "question_tag",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
}
