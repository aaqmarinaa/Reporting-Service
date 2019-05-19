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
@Table(name = "laporan_driver")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_at", "updated_at"}, 
        allowGetters = true)
public class Driver implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lap_driver;

    private Long id_driver;
    private Date tgl_transaksi;
    private Long id_order;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;
    
    public Long getId_lap_driver(){
    	return id_lap_driver;
    }
    public void setId_lap_cust(Long id_lap_driver) {
    	this.id_lap_driver = id_lap_driver;
    }
    
    public Long getId_driver(){
    	return id_driver;
    }
    public void setId_driver(Long id_driver) {
    	this.id_driver= id_driver;
    }

    public Date getTgl_transaksi(){
    	return tgl_transaksi;
    }
    public void setTgl_transaksi(Date tgl_transaksi) {
    	this.tgl_transaksi = tgl_transaksi;
    }
    
    public Long getId_order(){
    	return id_order;
    }
    public void setId_order(Long id_order) {
    	this.id_order = id_order;
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