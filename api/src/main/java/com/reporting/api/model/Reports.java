package com.reporting.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reports")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_at", "updated_at"}, 
        allowGetters = true)
public class Reports implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_reports;

    @NotBlank
    private String role;
    
    @NotBlank
    private Long id_role;
    
    @NotBlank
    private Long id_order;
    
    @NotBlank
    private Date tanggal_laporan;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;
    
    public Long getId_reports(){
    	return id_reports;
    }
    public void setId_reports(Long id_reports) {
    	this.id_reports = id_reports;
    }
    
    public String getRole(){
    	return role;
    }
    public void setRole(String role) {
    	this.role = role;
    }
    
    public Long getId_role(){
    	return id_role;
    }
    public void setId_role(Long id_role) {
    	this.id_role = id_role;
    }
    
    public Date getTanggal_laporan(){
    	return tanggal_laporan;
    }
    public void setTanggal_laporan(Date tanggal_laporan) {
    	this.tanggal_laporan = tanggal_laporan;
    }
    
    public Date getCreated_at() {
    	return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
}