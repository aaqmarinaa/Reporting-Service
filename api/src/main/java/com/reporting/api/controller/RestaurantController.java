package com.reporting.api.controller;

import com.reporting.api.exception.ResourceNotFoundException;
import com.reporting.api.model.*;
import com.reporting.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @PostMapping("/restaurants")
    public Restaurant createReport(@Valid @RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
    
    // Get 1 Report
    @GetMapping("/restaurants/getCust")
    public List<Restaurant> checkCust(@RequestHeader Long id_rest) {
        return restaurantRepository.ambilRestaurant(id_rest);
    }
    
    // Get Tanggal
    @GetMapping("/restaurants/getCustTanggal")
    public List<Restaurant> checkTanggal(@RequestHeader String tgl_transaksi) {
        return restaurantRepository.ambilTanggal(tgl_transaksi);
    }
    
    @CrossOrigin
    @GetMapping("/restaurants/get")
    public Map<String, Object> checkRestaurant(
    		@RequestParam(name = "id_rest", required = false) Long id_rest, 
    		@RequestParam(name = "tgl_transaksi", required = false) String tgl_transaksi) {
    	if (id_rest != null && tgl_transaksi != null) {
    		Map<String, Object> result = new HashMap<>();
			result.put("data", restaurantRepository.ambilBoth(tgl_transaksi, id_rest));
			return result;
//    		return restaurantRepository.ambilBoth(tgl_transaksi, id_rest);
    	}
    	else if (id_rest != null && tgl_transaksi == null) {
    		Map<String, Object> result = new HashMap<>();
			result.put("data", restaurantRepository.ambilRestaurant(id_rest));
			return result;
//    		return restaurantRepository.ambilRestaurant(id_rest);
    	}
    	else if (id_rest == null && tgl_transaksi != null) {
    		Map<String, Object> result = new HashMap<>();
			result.put("data", restaurantRepository.ambilTanggal(tgl_transaksi));
			return result;
//    		return restaurantRepository.ambilTanggal(tgl_transaksi);
    	}
    	else {
    		Map<String, Object> result = new HashMap<>();
			result.put("data", restaurantRepository.findAll());
			return result;
//    		return restaurantRepository.findAll();
    	}
    }
    
    // Update a report
    @PutMapping("/restaurants/{id_lap_rest}")
    public Restaurant updateRestReport(@PathVariable(value = "id_lap_rest") Long restId,
                                @Valid @RequestBody Restaurant restReports) {

        Restaurant restaurant = restaurantRepository.findById(restId)
                .orElseThrow(() -> new ResourceNotFoundException("laporan_restaurant", "id_lap_rest", restId));

        restaurant.setId_rest(restReports.getId_rest());
        restaurant.setTgl_transaksi(restReports.getTgl_transaksi());
        restaurant.setMenu_id(restReports.getMenu_id());

        Restaurant updatedRestReport = restaurantRepository.save(restaurant);
        return updatedRestReport;
    }
}