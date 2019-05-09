package com.reporting.api.controller;

import com.reporting.api.exception.ResourceNotFoundException;
import com.reporting.api.model.Details;
import com.reporting.api.repository.DetailsRepository;
import com.reporting.api.repository.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DetailsController {

    @Autowired
    DetailsRepository detailsRepository;

    // Get All Details
    @GetMapping("/details")
    public List<Details> getAllReports() {
        return detailsRepository.findAll();
    }
    // Create a new Details
    @PostMapping("/details")
    public Details createDetail(@Valid @RequestBody Details detail) {
        return detailsRepository.save(detail);
    }
    // Get 1 Details
    @GetMapping("/details/{id_detail}")
    public Details getDetailById(@PathVariable(value = "id_detail") Long detailId) {
        return detailsRepository.findById(detailId)
                .orElseThrow(() -> new ResourceNotFoundException("detail_laporan", "id_detail", detailId));
    }
    // Update a Details
    @PutMapping("/details/{id_detail}")
    public Details updateDetail(@PathVariable(value = "id_detail") Long detailId,
                                @Valid @RequestBody Details reportDetails) {

        Details details = detailsRepository.findById(detailId)
                .orElseThrow(() -> new ResourceNotFoundException("detail_laporan", "id_detail", detailId));

        details.setNama_menu(reportDetails.getNama_menu());
        details.setJumlah_terjual(reportDetails.getJumlah_terjual());

        Details updatedDetail = detailsRepository.save(details);
        return updatedDetail;
    }
    // Delete a Details
    @DeleteMapping("/details/{id_detail}")
    public ResponseEntity<?> deleteDetail(@PathVariable(value = "id_detail") Long detailId) {
        Details details = detailsRepository.findById(detailId)
                .orElseThrow(() -> new ResourceNotFoundException("detail_laporan", "id_detail", detailId));

        detailsRepository.delete(details);

        return ResponseEntity.ok().build();
    }
}