package com.reporting.api.repository;

import com.reporting.api.model.Details;
import com.reporting.api.model.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Long> {

}