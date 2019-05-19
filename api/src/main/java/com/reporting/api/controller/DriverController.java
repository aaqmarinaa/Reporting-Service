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
public class DriverController {

    @Autowired
    DriverRepository driverRepository;

    // Get All Reports
    @GetMapping("/drivers")
    public List<Driver> getAllDriverReports() {
        return driverRepository.findAll();
    }
    
    // Create a new Report
//    @PostMapping("/reports")
//    public Reports createReport(@Valid @RequestBody Reports report) {
//        return reportsRepository.save(report);
//    }
    
    // Get 1 Report
    @GetMapping("/drivers/{id_lap_driver}")
    public Driver getReportById(@PathVariable(value = "id_lap_driver") Long driverId) {
        return driverRepository.findById(driverId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan_driver", "id_lap_driver", driverId));
    }
    
    // Update a report
    @PutMapping("/drivers/{id_lap_driver")
    public Driver updateDriverReport(@PathVariable(value = "id_lap_driver") Long driverId,
                                @Valid @RequestBody Driver driverReports) {

        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan_driver", "id_lap_driver", driverId));

        driver.setTgl_transaksi(driverReports.getTgl_transaksi());
        
        Driver updatedDriverReport = driverRepository.save(driver);
        return updatedDriverReport;
    }
}