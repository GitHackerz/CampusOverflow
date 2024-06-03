package com.example.campusoverflow.tag;

import com.example.campusoverflow.tag.dto.TagRequestNew;
import com.example.campusoverflow.tag.dto.TagRequestUpdate;
import org.springframework.stereotype.Service;

@Service
public class TagMapper {

    public Tag toTag(TagRequestNew request) {
        return Tag.builder()
                .name(request.getName())
                .build();
    }

    public Tag toTag(TagRequestUpdate request) {
        return Tag.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }

}
