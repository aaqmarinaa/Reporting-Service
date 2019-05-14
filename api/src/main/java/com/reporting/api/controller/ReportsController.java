package com.reporting.api.controller;

import com.reporting.api.exception.ResourceNotFoundException;
import com.reporting.api.model.Reports;
import com.reporting.api.repository.ReportsRepository;
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
//    @PostMapping("/reports")
//    public Reports createReport(@Valid @RequestBody Reports report) {
//        return reportsRepository.save(report);
//    }
    
    // Get 1 Report
    @GetMapping("/reports/{id_report}")
    public Reports getReportById(@PathVariable(value = "id_report") Long reportId) {
        return reportsRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("reports", "id_report", reportId));
    }
    
    // Get All Reports By Role
    @GetMapping("/reports/{role}")
    public Reports getRoleById(@PathVariable(value = "role") Long role) {
        return reportsRepository.findById(role)
                .orElseThrow(() -> new ResourceNotFoundException("reports", "role", role));
    }
    
    // Update a report
    @PutMapping("/reports/{id_report}")
    public Reports updateReport(@PathVariable(value = "id_report") Long reportId,
                                @Valid @RequestBody Reports reportDetails) {

        Reports reports = reportsRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("reports", "id_report", reportId));

        reports.setTanggal_laporan(reportDetails.getTanggal_laporan());

        Reports updatedReport = reportsRepository.save(reports);
        return updatedReport;
    }
}