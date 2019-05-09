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
@Table(name = "detail_laporan")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"create_at", "updated_at"}, 
        allowGetters = true)
public class Details implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detail;
    
    @Column(nullable = false)
    private Long id_laporan;

    @NotBlank
    private String nama_menu;

    @NotBlank
    private int jumlah_terjual;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date created_at;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updated_at;

    public Long getId_detail(){
    	return id_detail;
    }
    
    public void setId_detail(Long id_detail) {
    	this.id_detail = id_detail;
    }
    
    public Long getId_laporan(){
    	return id_laporan;
    }
    
    public void setId_laporan(Long id_laporan) {
    	this.id_laporan = id_laporan;
    }
    
    public String getNama_menu(){
    	return nama_menu;
    }
    
    public void setNama_menu(String nama_menu) {
    	this.nama_menu = nama_menu;
    }
    
    public int getJumlah_terjual(){
    	return jumlah_terjual;
    }
    
    public void setJumlah_terjual(int jumlah_terjual) {
    	this.jumlah_terjual = jumlah_terjual;
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