package com.reporting.api.controller;

import com.reporting.api.exception.ResourceNotFoundException;
import com.reporting.api.model.*;
import com.reporting.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reports")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    // Get All Reports
    @GetMapping("/customers")
    public List<Customer> getAllCustReports() {
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
    @PutMapping("/customers/{id_lap_cust}")
    public Customer updateCustReport(@PathVariable(value = "id_lap_cust") Long custId,
                                @Valid @RequestBody Customer custReports) {

        Customer customer = customerRepository.findById(custId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan_customer", "id_lap_cust", custId));
        
        customer.setId_cust(custReports.getId_cust());
        customer.setTgl_transaksi(custReports.getTgl_transaksi());
        customer.setId_order(custReports.getId_order());

        Customer updatedCustReport = customerRepository.save(customer);
        return updatedCustReport;
    }
}