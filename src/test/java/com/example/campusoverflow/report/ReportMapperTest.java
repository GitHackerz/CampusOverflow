package com.example.campusoverflow.report;

import com.example.campusoverflow.answer.Answer;
import com.example.campusoverflow.answer.AnswerRepository;
import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.question.Question;
import com.example.campusoverflow.question.QuestionRepository;
import com.example.campusoverflow.report.dto.ReportRequestNewDto;
import com.example.campusoverflow.report.dto.ReportRequestUpdateDto;
import com.example.campusoverflow.report.enums.ReportType;
import com.example.campusoverflow.user.User;
import com.example.campusoverflow.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ReportMapperTest {

    private UserRepository userRepository;
    private AnswerRepository answerRepository;
    private QuestionRepository questionRepository;
    private ReportMapper reportMapper;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        answerRepository = Mockito.mock(AnswerRepository.class);
        questionRepository = Mockito.mock(QuestionRepository.class);
        reportMapper = new ReportMapper(userRepository, answerRepository, questionRepository);
    }

    // REQUEST NEW DTO

    @Test
    void toReport_withReportRequestNewDto_success() {
        // Arrange
        User user = new User();
        user.setId(1L);
        User reportedUser = new User();
        reportedUser.setId(2L);

        ReportRequestNewDto dto = new ReportRequestNewDto();
        dto.setUserId(1L);
        dto.setReportedUserId(2L);
        dto.setTitle("Spam");
        dto.setDescription("This is a spam answer.");
        dto.setType(ReportType.USER_REPORT);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.findById(2L)).thenReturn(Optional.of(reportedUser));

        // Act
        Report report = reportMapper.toReport(dto);

        // Assert
        assertNotNull(report);
        assertEquals("Spam", report.getTitle());
        assertEquals("This is a spam answer.", report.getDescription());
        assertEquals(ReportType.USER_REPORT, report.getType());
        assertEquals(user, report.getUser());
        assertEquals(reportedUser, report.getReportedUser());
    }

    @Test
    void toReport_withReportRequestNewDto_reportedAnswer() {
        // Arrange
        User user = new User();
        user.setId(1L);
        Answer reportedAnswer = new Answer();
        reportedAnswer.setId(2L);

        ReportRequestNewDto dto = new ReportRequestNewDto();
        dto.setUserId(1L);
        dto.setReportedAnswerId(2L);
        dto.setTitle("Spam");
        dto.setDescription("This is a spam answer.");
        dto.setType(ReportType.ANSWER_REPORT);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(answerRepository.findById(2L)).thenReturn(Optional.of(reportedAnswer));

        // Act
        Report report = reportMapper.toReport(dto);

        // Assert
        assertNotNull(report);
        assertEquals("Spam", report.getTitle());
        assertEquals("This is a spam answer.", report.getDescription());
        assertEquals(ReportType.ANSWER_REPORT, report.getType());
        assertEquals(user, report.getUser());
        assertEquals(reportedAnswer, report.getReportedAnswer());
    }

    @Test
    void toReport_withReportRequestNewDto_reportedQuestion() {
        // Arrange
        User user = new User();
        user.setId(1L);
        Question reportedQuestion = new Question();
        reportedQuestion.setId(2L);

        ReportRequestNewDto dto = new ReportRequestNewDto();
        dto.setUserId(1L);
        dto.setReportedQuestionId(2L);
        dto.setTitle("Spam");
        dto.setDescription("This is a spam answer.");
        dto.setType(ReportType.QUESTION_REPORT);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(questionRepository.findById(2L)).thenReturn(Optional.of(reportedQuestion));

        // Act
        Report report = reportMapper.toReport(dto);

        // Assert
        assertNotNull(report);
        assertEquals("Spam", report.getTitle());
        assertEquals("This is a spam answer.", report.getDescription());
        assertEquals(ReportType.QUESTION_REPORT, report.getType());
        assertEquals(user, report.getUser());
        assertEquals(reportedQuestion, report.getReportedQuestion());
    }

    @Test
    void toReport_withReportRequestNewDto_userNotFound() {
        // Arrange
        ReportRequestNewDto dto = new ReportRequestNewDto();
        dto.setUserId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> reportMapper.toReport(dto));
    }

    @Test
    void toReport_withReportRequestNewDto_reportedUserNotFound() {
        // Arrange
        User user = new User();
        user.setId(1L);

        ReportRequestNewDto dto = new ReportRequestNewDto();
        dto.setUserId(1L);
        dto.setReportedUserId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> reportMapper.toReport(dto));
    }

    @Test
    void toReport_withReportRequestNewDto_reportedAnswerNotFound() {
        // Arrange
        User user = new User();
        user.setId(1L);

        ReportRequestNewDto dto = new ReportRequestNewDto();
        dto.setUserId(1L);
        dto.setReportedAnswerId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(answerRepository.findById(2L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> reportMapper.toReport(dto));
    }

    @Test
    void toReport_withReportRequestNewDto_reportedQuestionNotFound() {
        // Arrange
        User user = new User();
        user.setId(1L);

        ReportRequestNewDto dto = new ReportRequestNewDto();
        dto.setUserId(1L);
        dto.setReportedQuestionId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(questionRepository.findById(2L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> reportMapper.toReport(dto));
    }

    // REQUEST UPDATE DTO

    @Test
    void toReport_withReportRequestUpdateDto_success() {
        // Arrange
        User user = new User();
        user.setId(1L);
        User reportedUser = new User();
        reportedUser.setId(2L);

        ReportRequestUpdateDto dto = new ReportRequestUpdateDto();
        dto.setId(1L);
        dto.setUserId(1L);
        dto.setReportedUserId(2L);
        dto.setTitle("Spam");
        dto.setDescription("This is a spam answer.");
        dto.setResolved(true);
        dto.setType(ReportType.USER_REPORT);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.findById(2L)).thenReturn(Optional.of(reportedUser));

        // Act
        Report report = reportMapper.toReport(dto);

        // Assert
        assertNotNull(report);
        assertEquals(1L, report.getId());
        assertEquals("Spam", report.getTitle());
        assertEquals("This is a spam answer.", report.getDescription());
        assertEquals(ReportType.USER_REPORT, report.getType());
        assertTrue(report.isResolved());
        assertEquals(user, report.getUser());
        assertEquals(reportedUser, report.getReportedUser());
    }

    @Test
    void toReport_withReportRequestUpdateDto_reportedAnswer() {
        // Arrange
        User user = new User();
        user.setId(1L);
        Answer reportedAnswer = new Answer();
        reportedAnswer.setId(2L);

        ReportRequestUpdateDto dto = new ReportRequestUpdateDto();
        dto.setId(1L);
        dto.setUserId(1L);
        dto.setReportedAnswerId(2L);
        dto.setTitle("Spam");
        dto.setDescription("This is a spam answer.");
        dto.setResolved(true);
        dto.setType(ReportType.ANSWER_REPORT);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(answerRepository.findById(2L)).thenReturn(Optional.of(reportedAnswer));

        // Act
        Report report = reportMapper.toReport(dto);

        // Assert
        assertNotNull(report);
        assertEquals(1L, report.getId());
        assertEquals("Spam", report.getTitle());
        assertEquals("This is a spam answer.", report.getDescription());
        assertEquals(ReportType.ANSWER_REPORT, report.getType());
        assertTrue(report.isResolved());
        assertEquals(user, report.getUser());
        assertEquals(reportedAnswer, report.getReportedAnswer());
    }

    @Test
    void toReport_withReportRequestUpdateDto_reportedQuestion() {
        // Arrange
        User user = new User();
        user.setId(1L);
        Question reportedQuestion = new Question();
        reportedQuestion.setId(2L);

        ReportRequestUpdateDto dto = new ReportRequestUpdateDto();
        dto.setId(1L);
        dto.setUserId(1L);
        dto.setReportedQuestionId(2L);
        dto.setTitle("Spam");
        dto.setDescription("This is a spam answer.");
        dto.setResolved(true);
        dto.setType(ReportType.QUESTION_REPORT);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(questionRepository.findById(2L)).thenReturn(Optional.of(reportedQuestion));

        // Act
        Report report = reportMapper.toReport(dto);

        // Assert
        assertNotNull(report);
        assertEquals(1L, report.getId());
        assertEquals("Spam", report.getTitle());
        assertEquals("This is a spam answer.", report.getDescription());
        assertEquals(ReportType.QUESTION_REPORT, report.getType());
        assertTrue(report.isResolved());
        assertEquals(user, report.getUser());
        assertEquals(reportedQuestion, report.getReportedQuestion());
    }

    @Test
    void toReport_withReportRequestUpdateDto_userNotFound() {
        // Arrange
        ReportRequestUpdateDto dto = new ReportRequestUpdateDto();
        dto.setUserId(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> reportMapper.toReport(dto));
    }

    @Test
    void toReport_withReportRequestUpdateDto_reportedUserNotFound() {
        // Arrange
        User user = new User();
        user.setId(1L);

        ReportRequestUpdateDto dto = new ReportRequestUpdateDto();
        dto.setUserId(1L);
        dto.setReportedUserId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> reportMapper.toReport(dto));
    }

    @Test
    void toReport_withReportRequestUpdateDto_reportedAnswerNotFound() {
        // Arrange
        User user = new User();
        user.setId(1L);

        ReportRequestUpdateDto dto = new ReportRequestUpdateDto();
        dto.setUserId(1L);
        dto.setReportedAnswerId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(answerRepository.findById(2L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> reportMapper.toReport(dto));
    }

    @Test
    void toReport_withReportRequestUpdateDto_reportedQuestionNotFound() {
        // Arrange
        User user = new User();
        user.setId(1L);

        ReportRequestUpdateDto dto = new ReportRequestUpdateDto();
        dto.setUserId(1L);
        dto.setReportedQuestionId(2L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(questionRepository.findById(2L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> reportMapper.toReport(dto));
    }


}
