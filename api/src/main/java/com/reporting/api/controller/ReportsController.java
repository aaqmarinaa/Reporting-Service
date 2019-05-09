package com.reporting.api.controller;

import com.reporting.api.exception.ResourceNotFoundException;
import com.reporting.api.model.Reports;
import com.reporting.api.repository.ReportsRepository;
import com.reporting.api.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportsController {

    @Autowired
    ReportsRepository reportsRepository;

    // Get All Reports
    @GetMapping("/reports")
    public List<Reports> getAllReports() {
        return reportsRepository.findAll();
    }
    // Create a new Report
    @PostMapping("/reports")
    public Reports createReport(@Valid @RequestBody Reports report) {
        return reportsRepository.save(report);
    }
    // Get 1 Report
    @GetMapping("/reports/{id_laporan}")
    public Reports getReportById(@PathVariable(value = "id_laporan") Long reportId) {
        return reportsRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan", "id_laporan", reportId));
    }
    // Update a report
    @PutMapping("/reports/{id_laporan}")
    public Reports updateReport(@PathVariable(value = "id_laporan") Long reportId,
                                @Valid @RequestBody Reports reportDetails) {

        Reports reports = reportsRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("lapora", "id_laporan", reportId));

        reports.setTgl_laporan(reportDetails.getTgl_laporan());

        Reports updatedReport = reportsRepository.save(reports);
        return updatedReport;
    }
    // Delete a report
    @DeleteMapping("/reports/{id_laporan}")
    public ResponseEntity<?> deleteReport(@PathVariable(value = "id_laporan") Long reportId) {
        Reports reports = reportsRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan", "id_laporan", reportId));

        reportsRepository.delete(reports);

        return ResponseEntity.ok().build();
    }
}