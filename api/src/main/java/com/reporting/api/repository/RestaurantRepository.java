package com.reporting.api.repository;

import com.reporting.api.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
		@Query(value = "SELECT * FROM laporan_restaurant lr WHERE lr.id_rest = :id_rest", nativeQuery = true)
	List<Restaurant> ambilRestaurant(@Param("id_rest") Long id_rest);
		
		@Query(value = "SELECT * FROM laporan_restaurant lr WHERE lr.tgl_transaksi = :tgl_transaksi", nativeQuery = true)
	List<Restaurant> ambilTanggal(@Param("tgl_transaksi") String tgl_transaksi);
}