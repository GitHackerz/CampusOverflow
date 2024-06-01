package com.example.campusoverflow.question;

import com.example.campusoverflow.question.dto.QuestionRequest;
import com.example.campusoverflow.tag.Tag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionMapperTest {

    QuestionMapper questionMapper;

    @BeforeEach
    void setUp() {
        questionMapper = new QuestionMapper();
    }

    @Test
    void should_map_questionRequest_to_question() {
        List<Tag> tags = List.of(new Tag("tag1"), new Tag("tag2"));
        QuestionRequest request = new QuestionRequest("title", "content", tags);

        Question question = questionMapper.toQuestion(request);

        assertEquals(request.getTitle(), question.getTitle());
        assertEquals(request.getContent(), question.getContent());
        assertEquals(request.getTags(), question.getTags());
    }

    @Test
    void should_map_questionRequest_to_question_with_empty_tags() {
        List<Tag> tags = List.of();
        QuestionRequest request = new QuestionRequest("title", "content", tags);

        Question question = questionMapper.toQuestion(request);

        assertEquals(request.getTitle(), question.getTitle());
        assertEquals(request.getContent(), question.getContent());
        assertEquals(request.getTags(), question.getTags());
    }

    @Test
    void should_map_questionRequest_to_question_with_null_tags() {
        QuestionRequest request = new QuestionRequest("title", "content", null);

        Question question = questionMapper.toQuestion(request);

        assertEquals(request.getTitle(), question.getTitle());
        assertEquals(request.getContent(), question.getContent());
        assertNull(question.getTags());

        System.out.println(question);
    }

    @Test
    void should_throw_exception_when_questionRequest_is_null() {
        assertThrows(NullPointerException.class, () -> questionMapper.toQuestion(null));
    }

    @Test
    void should_throw_exception_when_questionRequest_title_is_null() {
        List<Tag> tags = List.of(new Tag("tag1"), new Tag("tag2"));
        QuestionRequest request = new QuestionRequest(null, "content", tags);

        assertThrows(NullPointerException.class, () -> questionMapper.toQuestion(request));
    }
}