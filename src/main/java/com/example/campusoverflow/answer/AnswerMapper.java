package com.example.campusoverflow.answer;

import com.example.campusoverflow.answer.dto.AnswerRequestNewDto;
import com.example.campusoverflow.answer.dto.AnswerRequestUpdateDto;
import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.question.Question;
import com.example.campusoverflow.question.QuestionRepository;
import com.example.campusoverflow.user.User;
import com.example.campusoverflow.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnswerMapper {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;

    public Answer toAnswer(AnswerRequestNewDto answerRequestDto) {
        User user = userRepository.findById(answerRequestDto.getUserId()).orElseThrow(() -> new NotFoundException("User not found"));
        Question question = questionRepository.findById(answerRequestDto.getQuestionId()).orElseThrow(() -> new NotFoundException("Question not found"));
        return Answer.builder()
                .content(answerRequestDto.getContent())
                .user(user)
                .question(question)
                .build();
    }

    public Answer toAnswer(AnswerRequestUpdateDto answerRequestDto) {
        Answer answer = answerRepository.findById(answerRequestDto.getId()).orElseThrow(() -> new NotFoundException("Answer not found"));
        return Answer.builder()
                .id(answerRequestDto.getId())
                .content(answerRequestDto.getContent())
                .user(answer.getUser())
                .question(answer.getQuestion())
                .build();
    }
}
