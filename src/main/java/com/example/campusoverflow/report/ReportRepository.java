package com.example.campusoverflow.report;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
    Iterable<Report> findAllByUserId(Long userId);

    Iterable<Report> findAllByTitleContaining(String query);
}
