package com.example.campusoverflow.report;

import com.example.campusoverflow.answer.Answer;
import com.example.campusoverflow.answer.AnswerRepository;
import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.question.Question;
import com.example.campusoverflow.question.QuestionRepository;
import com.example.campusoverflow.report.dto.ReportRequestNewDto;
import com.example.campusoverflow.report.dto.ReportRequestUpdateDto;
import com.example.campusoverflow.user.User;
import com.example.campusoverflow.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReportMapper {

    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public Report toReport(ReportRequestNewDto requestNewDto) {
        User user = userRepository.findById(requestNewDto.getUserId()).orElseThrow(() -> new NotFoundException("User not found"));

        User reportedUser = null;
        Answer reportedAnswer = null;
        Question reportedQuestion = null;

        if (requestNewDto.getReportedUserId() != null)
            reportedUser = userRepository.findById(requestNewDto.getReportedUserId()).orElseThrow(() -> new NotFoundException("User not found"));

        if (requestNewDto.getReportedAnswerId() != null)
            reportedAnswer = answerRepository.findById(requestNewDto.getReportedAnswerId()).orElseThrow(() -> new NotFoundException("Answer not found"));

        if (requestNewDto.getReportedQuestionId() != null)
            reportedQuestion = questionRepository.findById(requestNewDto.getReportedQuestionId()).orElseThrow(() -> new NotFoundException("Question not found"));

        return Report.builder()
                .title(requestNewDto.getTitle())
                .description(requestNewDto.getDescription())
                .type(requestNewDto.getType())
                .reportedUser(reportedUser)
                .reportedAnswer(reportedAnswer)
                .reportedQuestion(reportedQuestion)
                .user(user)
                .build();
    }

    public Report toReport(ReportRequestUpdateDto requestUpdateDto) {
        User user = userRepository.findById(requestUpdateDto.getUserId()).orElseThrow(() -> new NotFoundException("User not found"));

        User reportedUser = null;
        Answer reportedAnswer = null;
        Question reportedQuestion = null;

        if (requestUpdateDto.getReportedUserId() != null)
            reportedUser = userRepository.findById(requestUpdateDto.getReportedUserId()).orElseThrow(() -> new NotFoundException("User not found"));

        if (requestUpdateDto.getReportedAnswerId() != null)
            reportedAnswer = answerRepository.findById(requestUpdateDto.getReportedAnswerId()).orElseThrow(() -> new NotFoundException("Answer not found"));

        if (requestUpdateDto.getReportedQuestionId() != null)
            reportedQuestion = questionRepository.findById(requestUpdateDto.getReportedQuestionId()).orElseThrow(() -> new NotFoundException("Question not found"));

        return Report.builder()
                .id(requestUpdateDto.getId())
                .title(requestUpdateDto.getTitle())
                .description(requestUpdateDto.getDescription())
                .isResolved(requestUpdateDto.isResolved())
                .type(requestUpdateDto.getType())
                .reportedUser(reportedUser)
                .reportedAnswer(reportedAnswer)
                .reportedQuestion(reportedQuestion)
                .user(user)
                .build();
    }
}
