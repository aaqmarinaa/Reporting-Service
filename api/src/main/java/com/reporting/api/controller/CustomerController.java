package com.reporting.api.controller;

import com.reporting.api.exception.ResourceNotFoundException;
import com.reporting.api.model.*;
import com.reporting.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    // Get All Reports
    @GetMapping("/customers")
    public List<Customer> getAllReports() {
        return customerRepository.findAll();
    }
    
    // Create a new Report
//    @PostMapping("/reports")
//    public Reports createReport(@Valid @RequestBody Reports report) {
//        return reportsRepository.save(report);
//    }
    
    // Get 1 Report
    @GetMapping("/customers/{id_lap_cust}")
    public Customer getReportById(@PathVariable(value = "id_lap_cust") Long custId) {
        return customerRepository.findById(custId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan_customer", "id_lap_cust", custId));
    }
    
    // Update a report
    @PutMapping("/reports/{id_report}")
    public Customer updateCustReport(@PathVariable(value = "id_lap_cust") Long custId,
                                @Valid @RequestBody Customer reportCustDetails) {

    	Customer customers = customerRepository.findById(custId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan_customer", "id_lap_cust", custId));

        customers.setTgl_transaksi(Customer.getTgl_transaksi());

        Reports updatedCustReport= customerRepository.save(customers);
        return updatedCustreport;
    }
}