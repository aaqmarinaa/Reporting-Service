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
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    // Get All Reports
    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestReports() {
        return restaurantRepository.findAll();
    }
    
    // Create a new Report
//    @PostMapping("/reports")
//    public Reports createReport(@Valid @RequestBody Reports report) {
//        return reportsRepository.save(report);
//    }
    
    // Get 1 Report
    @GetMapping("/restaurants/{id_lap_rest}")
    public Restaurant getReportById(@PathVariable(value = "id_lap_rest") Long restId) {
        return restaurantRepository.findById(restId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan_restaurant", "id_lap_rest", restId));
    }
    
    // Update a report
    @PutMapping("/restaurants/{id_lap_rest}")
    public Restaurant updateRestReport(@PathVariable(value = "id_lap_rest") Long restId,
                                @Valid @RequestBody Restaurant restReports) {

        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan_restaurant", "id_lap_rest", restId));

        restaurant.setTgl_transaksi(restReports.getTgl_transaksi());

        Restaurant updatedRestReport = restaurantRepository.save(restaurant);
        return updatedRestReport;
    }
}