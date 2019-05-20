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
@Table(name = "laporan_restaurant")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_at", "updated_at"}, 
        allowGetters = true)
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lap_rest;

    private Long id_rest;
    private Long menu_id;
    private int total;
    private String tgl_transaksi;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;
    
    public Long getId_lap_rest(){
    	return id_lap_rest;
    }
    public void setId_lap_rest(Long id_lap_rest) {
    	this.id_lap_rest = id_lap_rest;
    }
    
    public Long getId_rest(){
    	return id_rest;
    }
    public void setId_rest(Long id_rest) {
    	this.id_rest = id_rest;
    }
    
    public Long getMenu_id(){
    	return menu_id;
    }
    public void setMenu_id(Long menu_id) {
    	this.menu_id = menu_id;
    }
    
    public int getTotal(){
    	return total;
    }
    public void setTotal(int total) {
    	this.total = total;
    }

    public String getTgl_transaksi(){
    	return tgl_transaksi;
    }
    public void setTgl_transaksi(String tgl_transaksi) {
    	this.tgl_transaksi = tgl_transaksi;
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