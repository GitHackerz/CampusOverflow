package com.example.campusoverflow.question;

import com.example.campusoverflow.common.PageResponse;
import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.exceptions.UnAuthorizedException;
import com.example.campusoverflow.question.dto.QuestionRequest;
import com.example.campusoverflow.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.*;
import org.springframework.security.core.Authentication;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class QuestionServiceTest {

    @Mock
    private QuestionRepository repository;

    @Mock
    private QuestionMapper questionMapper;

    @Mock
    private Authentication authentication;

    @InjectMocks
    private QuestionService questionService;

    private User user;
    private Question question;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(1L);
        question = new Question();
        question.setId(1L);
        question.setUser(user);
    }

    @Test
    public void testSave() {
        QuestionRequest request = new QuestionRequest();
        when(questionMapper.toQuestion(request)).thenReturn(question);
        when(authentication.getPrincipal()).thenReturn(user);
        when(repository.save(any(Question.class))).thenReturn(question);

        Question savedQuestion = questionService.save(request, authentication);

        assertNotNull(savedQuestion);
        assertEquals(question.getId(), savedQuestion.getId());
        verify(repository, times(1)).save(question);
    }

    @Test
    public void testFindById_Success() {
        when(repository.findById(1L)).thenReturn(Optional.of(question));

        Question foundQuestion = questionService.findById(1L);

        assertNotNull(foundQuestion);
        assertEquals(question.getId(), foundQuestion.getId());
    }

    @Test
    public void testFindById_NotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> questionService.findById(1L));
    }

    @Test
    public void testDeleteById_Success() {
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.findById(1L)).thenReturn(Optional.of(question));
        when(authentication.getPrincipal()).thenReturn(user);

        assertDoesNotThrow(() -> questionService.deleteById(1L, authentication));
        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteById_NotFound() {
        when(repository.existsById(1L)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> questionService.deleteById(1L, authentication));
        verify(repository, never()).deleteById(1L);
    }

    @Test
    public void testDeleteById_UnAuthorized() {
        User anotherUser = new User();
        anotherUser.setId(2L);
        question.setUser(anotherUser);

        when(repository.existsById(1L)).thenReturn(true);
        when(repository.findById(1L)).thenReturn(Optional.of(question));
        when(authentication.getPrincipal()).thenReturn(user);

        assertThrows(UnAuthorizedException.class, () -> questionService.deleteById(1L, authentication));
        verify(repository, never()).deleteById(1L);
    }

    @Test
    public void testUpdate() {
        when(repository.save(question)).thenReturn(question);

        Question updatedQuestion = questionService.update(question);

        assertNotNull(updatedQuestion);
        assertEquals(question.getId(), updatedQuestion.getId());
        verify(repository, times(1)).save(question);
    }

    @Test
    public void testFindAll() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("createdAt").descending());
        Page<Question> questionPage = new PageImpl<>(Collections.singletonList(question));
        when(repository.findAll(pageable)).thenReturn(questionPage);

        PageResponse<Question> response = questionService.findAll(0, 10);

        assertNotNull(response);
        assertEquals(1, response.getTotalElements());
        verify(repository, times(1)).findAll(pageable);
    }

    @Test
    public void testSearch() {
        int page = 0;
        int size = 10;
        String query = "test";
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Question> questionPage = new PageImpl<>(Collections.singletonList(question));
        when(repository.findAllByTitleAndContentContaining(query, pageable)).thenReturn(questionPage);

        PageResponse<Question> response = questionService.search(page, size, query);

        assertNotNull(response);
        assertEquals(1, response.getTotalElements());
        verify(repository, times(1)).findAllByTitleAndContentContaining(query, pageable);
    }

    @Test
    public void testFindAllByUser() {
        int page = 0;
        int size = 10;
        User user = new User();
        user.setId(1L);
        Authentication authentication = mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn(user);
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Question> questionPage = new PageImpl<>(Collections.singletonList(question));
        when(repository.findAllByUserId(user.getId(), pageable)).thenReturn(questionPage);

        PageResponse<Question> response = questionService.findAllByUser(page, size, authentication);

        assertNotNull(response);
        assertEquals(1, response.getTotalElements());
        verify(repository, times(1)).findAllByUserId(user.getId(), pageable);
    }

}
