package com.example.campusoverflow.answer;

import com.example.campusoverflow.answer.dto.AnswerRequestNewDto;
import com.example.campusoverflow.answer.dto.AnswerRequestUpdateDto;
import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.question.QuestionRepository;
import com.example.campusoverflow.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnswerService {

    private final AnswerRepository repository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final AnswerMapper mapper;

    public Answer save(AnswerRequestNewDto requestDto) {
        Answer answer = mapper.toAnswer(requestDto);
        return repository.save(answer);
    }

    public Answer findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<Answer> findAllByQuestionId(Long questionId) {
        questionRepository.findById(questionId).orElseThrow(() -> new NotFoundException("Question not found"));
        return repository.findAllByQuestionId(questionId);
    }

    public Iterable<Answer> findAllByUserId(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        return repository.findAllByUserId(userId);
    }

    public Answer update(AnswerRequestUpdateDto requestDto) {
        Answer answer = mapper.toAnswer(requestDto);
        return repository.save(answer);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
