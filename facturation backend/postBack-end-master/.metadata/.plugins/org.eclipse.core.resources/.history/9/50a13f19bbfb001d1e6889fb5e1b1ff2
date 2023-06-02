package com.app.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(	name = "application", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "code"),
			@UniqueConstraint(columnNames = "prix")
		})
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "code")
    @JsonProperty("code")
	private String code;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "libelle")
    @JsonProperty("libelle")
	private String libelle;
	
	@Column(name = "prix")
    @JsonProperty("prix")
	private BigDecimal prix;
	public Application() {
		
	}
	
	 public  Application( String code, String libelle,BigDecimal prix) {
	        this.code = code;
	        this.libelle = libelle;
	        this.prix = prix;
	        
	    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}}
