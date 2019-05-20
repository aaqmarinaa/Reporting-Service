package com.reporting.api.controller;

import com.reporting.api.exception.ResourceNotFoundException;
import com.reporting.api.model.*;
import com.reporting.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @PostMapping("/customers")
    public Customer createReport(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }
    
    // Get 1 Report
    @GetMapping("/customers/getCust")
    public List<Customer> checkCust(@RequestHeader Long id_cust) {
        return customerRepository.ambilCustomer(id_cust);
    }
    
    // Get Tanggal
    @GetMapping("/customers/getCustTanggal")
    public List<Customer> checkTanggal(@RequestHeader String tgl_transaksi) {
        return customerRepository.ambilTanggal(tgl_transaksi);
    }
    
    @CrossOrigin
    @GetMapping("/customers/get")
    public Map<String, Object> checkCustomer(
    		@RequestParam(name = "id_cust", required = false) Long id_cust, 
    		@RequestParam(name = "tgl_transaksi", required = false) String tgl_transaksi) {
    	if (id_cust != null && tgl_transaksi != null) {
	    	Map<String, Object> result = new HashMap<>();
			result.put("data", customerRepository.ambilBoth(tgl_transaksi, id_cust));
			return result;
//    		return customerRepository.ambilBoth(tgl_transaksi, id_cust);
    	}
    	else if (id_cust != null && tgl_transaksi == null) {
	    	Map<String, Object> result = new HashMap<>();
			result.put("data", customerRepository.ambilCustomer(id_cust));
			return result;
//    		return customerRepository.ambilCustomer(id_cust);
    	}
    	else if (id_cust == null && tgl_transaksi != null) {
	    	Map<String, Object> result = new HashMap<>();
			result.put("data", customerRepository.ambilTanggal(tgl_transaksi));
			return result;
//    		return customerRepository.ambilTanggal(tgl_transaksi);
    	}
    	else {
    		Map<String, Object> result = new HashMap<>();
    		result.put("data", customerRepository.findAll());
    		return result;
//    		return customerRepository.findAll();
    	}
    }
    
    // Update a report
    @PutMapping("/customers/{id_lap_cust}")
    public Customer updateCustReport(@PathVariable(value = "id_lap_cust") Long custId,
                                @Valid @RequestBody Customer custReports) {

        Customer customer = customerRepository.findById(custId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan_customer", "id_lap_cust", custId));
        
        customer.setId_cust(custReports.getId_cust());
        customer.setTgl_transaksi(custReports.getTgl_transaksi());
        customer.setMenu_id(custReports.getMenu_id());

        Customer updatedCustReport = customerRepository.save(customer);
        return updatedCustReport;
    }
}