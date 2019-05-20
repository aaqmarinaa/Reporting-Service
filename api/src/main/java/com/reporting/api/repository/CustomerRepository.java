package com.reporting.api.repository;

import com.reporting.api.model.*;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
		@Query(value = "SELECT * FROM laporan_customer lc WHERE lc.id_cust = :id_cust", nativeQuery = true)
	List<Customer> ambilCustomer(@Param("id_cust") Long id_cust);
		
		@Query(value = "SELECT * FROM laporan_customer lc WHERE lc.tgl_transaksi = :tgl_transaksi", nativeQuery = true)
	List<Customer> ambilTanggal(@Param("tgl_transaksi") String tgl_transaksi);
}