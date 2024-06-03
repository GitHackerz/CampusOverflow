package com.example.campusoverflow.report;

import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.report.dto.ReportRequestNewDto;
import com.example.campusoverflow.report.dto.ReportRequestUpdateDto;
import com.example.campusoverflow.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReportService {

    private final ReportRepository repository;
    private final UserRepository userRepository;
    private final ReportMapper mapper;

    public Report save(ReportRequestNewDto requestNewDto) {
        userRepository.findById(requestNewDto.getUserId()).orElseThrow(() -> new NotFoundException("User not found"));
        Report report = mapper.toReport(requestNewDto);
        return repository.save(report);
    }

    public Iterable<Report> findAllByUserId(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        return repository.findAllByUserId(userId);
    }

    public Report findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Report not found"));
    }

    public void deleteById(Long id) {
        repository.findById(id).orElseThrow(() -> new NotFoundException("Report not found"));
        repository.deleteById(id);
    }

    public Report update(ReportRequestUpdateDto requestUpdateDto) {
        repository.findById(requestUpdateDto.getId()).orElseThrow(() -> new NotFoundException("Report not found"));
        userRepository.findById(requestUpdateDto.getUserId()).orElseThrow(() -> new NotFoundException("User not found"));

        Report report = mapper.toReport(requestUpdateDto);
        return repository.save(report);
    }


    public Iterable<Report> search(String query) {
        return repository.findAllByTitleContaining(query);
    }
}
