package com.example.campusoverflow.tag;

import com.example.campusoverflow.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tag extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;
}
