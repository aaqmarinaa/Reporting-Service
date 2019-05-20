package com.reporting.api.repository;

import com.reporting.api.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	@Query(value="SELECT * FROM laporan_restaurant lr WHERE lr.id_rest= )
}