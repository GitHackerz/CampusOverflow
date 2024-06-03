package com.example.campusoverflow.report;

import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.report.dto.ReportRequestNewDto;
import com.example.campusoverflow.report.dto.ReportRequestUpdateDto;
import com.example.campusoverflow.report.enums.ReportType;
import com.example.campusoverflow.user.User;
import com.example.campusoverflow.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {

    @InjectMocks
    private ReportService reportService;

    @Mock
    private ReportRepository reportRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ReportMapper reportMapper;

    private Report report;
    private ReportRequestNewDto newDto;
    private ReportRequestUpdateDto updateDto;

    @BeforeEach
    void setUp() {
        report = new Report();
        report.setId(1L);
        report.setTitle("Spam");
        report.setDescription("This is a spam answer.");
        report.setType(ReportType.ANSWER_REPORT);

        newDto = new ReportRequestNewDto();
        newDto.setUserId(1L);
        newDto.setReportedAnswerId(2L);
        newDto.setTitle("Spam");
        newDto.setDescription("This is a spam answer.");
        newDto.setType(ReportType.ANSWER_REPORT);

        updateDto = new ReportRequestUpdateDto();
        updateDto.setId(1L);
        updateDto.setUserId(1L);
        updateDto.setTitle("Spam");
        updateDto.setDescription("This is a spam answer.");
        updateDto.setResolved(true);
        updateDto.setType(ReportType.ANSWER_REPORT);
    }

    @Test
    void save_success() {
        when(userRepository.findById(newDto.getUserId())).thenReturn(Optional.of(new User()));
        when(reportMapper.toReport(newDto)).thenReturn(report);
        when(reportRepository.save(report)).thenReturn(report);

        Report savedReport = reportService.save(newDto);

        assertNotNull(savedReport);
        assertEquals(report.getId(), savedReport.getId());
    }

    @Test
    void save_userNotFound() {
        when(userRepository.findById(newDto.getUserId())).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> reportService.save(newDto));

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void findAllByUserId_success() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User()));
        when(reportRepository.findAllByUserId(1L)).thenReturn(Collections.singletonList(report));

        Iterable<Report> reports = reportService.findAllByUserId(1L);

        assertNotNull(reports);
        assertTrue(reports.iterator().hasNext());
    }

    @Test
    void findAllByUserId_userNotFound() {
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> reportService.findAllByUserId(1L));

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void findById_success() {
        when(reportRepository.findById(1L)).thenReturn(Optional.of(report));

        Report foundReport = reportService.findById(1L);

        assertNotNull(foundReport);
        assertEquals(report.getId(), foundReport.getId());
    }

    @Test
    void findById_reportNotFound() {
        when(reportRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> reportService.findById(1L));

        assertEquals("Report not found", exception.getMessage());
    }

    @Test
    void deleteById_success() {
        when(reportRepository.findById(1L)).thenReturn(Optional.of(report));
        doNothing().when(reportRepository).deleteById(1L);

        assertDoesNotThrow(() -> reportService.deleteById(1L));
        verify(reportRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteById_reportNotFound() {
        when(reportRepository.findById(1L)).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> reportService.deleteById(1L));

        assertEquals("Report not found", exception.getMessage());
    }

    @Test
    void update_success() {
        when(reportRepository.findById(updateDto.getId())).thenReturn(Optional.of(report));
        when(userRepository.findById(updateDto.getUserId())).thenReturn(Optional.of(new User()));
        when(reportMapper.toReport(updateDto)).thenReturn(report);
        when(reportRepository.save(report)).thenReturn(report);

        Report updatedReport = reportService.update(updateDto);

        assertNotNull(updatedReport);
        assertEquals(report.getId(), updatedReport.getId());
    }

    @Test
    void update_reportNotFound() {
        when(reportRepository.findById(updateDto.getId())).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> reportService.update(updateDto));

        assertEquals("Report not found", exception.getMessage());
    }

    @Test
    void update_userNotFound() {
        when(reportRepository.findById(updateDto.getId())).thenReturn(Optional.of(report));
        when(userRepository.findById(updateDto.getUserId())).thenReturn(Optional.empty());

        NotFoundException exception = assertThrows(NotFoundException.class, () -> reportService.update(updateDto));

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void search_success() {
        when(reportRepository.findAllByTitleContaining("spam")).thenReturn(Collections.singletonList(report));

        Iterable<Report> reports = reportService.search("spam");

        assertNotNull(reports);
        assertTrue(reports.iterator().hasNext());
    }

    @Test
    void search_noResults() {
        when(reportRepository.findAllByTitleContaining("spam")).thenReturn(Collections.emptyList());

        Iterable<Report> reports = reportService.search("spam");

        assertNotNull(reports);
        assertFalse(reports.iterator().hasNext());
    }
}
