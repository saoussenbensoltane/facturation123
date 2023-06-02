package com.app.models;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(	name = "structure")
public class Structure {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank
	@Column(name = "code")
	private String code;
	
	@NotBlank
	@Column(name = "libelle")
	private String libelle;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_ministere")
	private Structure ministere;
	
	public Structure() {	
	}

	public Structure getMinistere() {
		return ministere;
	}

	public void setMinistere(Structure ministere) {
		this.ministere = ministere;
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

	

}



