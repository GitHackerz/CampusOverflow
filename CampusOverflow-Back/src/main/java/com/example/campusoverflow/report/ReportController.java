package com.example.campusoverflow.report;

import com.example.campusoverflow.report.dto.ReportRequestNewDto;
import com.example.campusoverflow.report.dto.ReportRequestUpdateDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("report")
@RequiredArgsConstructor
@Tag(name = "Report", description = "Report API")
public class ReportController {

    private final ReportService service;

    @GetMapping("user/{userId}")
    public ResponseEntity<Iterable<Report>> findAllReportsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.findAllByUserId(userId));
    }

    @GetMapping("{id}")
    public ResponseEntity<Report> findReportById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteReportById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Report> updateReport(@RequestBody ReportRequestUpdateDto requestUpdateDto) {
        return ResponseEntity.ok(service.update(requestUpdateDto));
    }

    @PostMapping
    public ResponseEntity<Report> saveReport(@RequestBody ReportRequestNewDto report) {
        return ResponseEntity.ok(service.save(report));
    }

    @GetMapping("search")
    public ResponseEntity<Iterable<Report>> searchReports(
            @RequestParam String query
    ) {
        return ResponseEntity.ok(service.search(query));
    }


}
