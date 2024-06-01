package com.example.campusoverflow.question;

import com.example.campusoverflow.common.PageResponse;
import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.exceptions.UnAuthorizedException;
import com.example.campusoverflow.question.dto.QuestionRequest;
import com.example.campusoverflow.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {

    private final QuestionRepository repository;
    private final QuestionMapper questionMapper;

    public Question save(QuestionRequest questionRequest, Authentication authentication) {
        Question question = questionMapper.toQuestion(questionRequest);
        question.setUser((User) authentication.getPrincipal());
        return repository.save(question);
    }

    public Question findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Question not found"));
    }

    public void deleteById(Long id, Authentication authentication) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Question not found");
        }
        User currentUser = (User) authentication.getPrincipal();
        Question question = repository.findById(id).orElseThrow();
        if (!question.getUser().getId().equals(currentUser.getId())) {
            throw new UnAuthorizedException("You are not authorized to delete this question");
        }
        repository.deleteById(id);
    }

    public Question update(Question question) {
        return repository.save(question);
    }

    public PageResponse<Question> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Question> questions = repository.findAll(pageable);
        List<Question> Questions = questions.stream()
                .toList();
        return new PageResponse<>(
                Questions,
                questions.getNumber(),
                questions.getSize(),
                questions.getTotalElements(),
                questions.getTotalPages(),
                questions.isFirst(),
                questions.isLast()
        );
    }

    public PageResponse<Question> search(int page, int size, String query) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Question> questions = repository.findAllByTitleAndContentContaining(query, pageable);
        List<Question> Questions = questions.stream()
                .toList();
        return new PageResponse<>(
                Questions,
                questions.getNumber(),
                questions.getSize(),
                questions.getTotalElements(),
                questions.getTotalPages(),
                questions.isFirst(),
                questions.isLast()
        );
    }

    public PageResponse<Question> findAllByUser(int page, int size, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Question> questions = repository.findAllByUserId(user.getId(), pageable);
        List<Question> Questions = questions.stream()
                .toList();
        return new PageResponse<>(
                Questions,
                questions.getNumber(),
                questions.getSize(),
                questions.getTotalElements(),
                questions.getTotalPages(),
                questions.isFirst(),
                questions.isLast()
        );
    }
}
