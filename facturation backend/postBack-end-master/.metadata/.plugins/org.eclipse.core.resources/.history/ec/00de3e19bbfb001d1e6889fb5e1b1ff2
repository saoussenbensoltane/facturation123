package com.app.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="facture")
public class Facture {
	 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "convention_id", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
	@JsonIgnore
	private Convention convention;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "structure", referencedColumnName = "id")
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
	@JsonIgnore
    private Structure structure;
	
	@Column(name = "date_echeance")
	private LocalDate dueDatefct;
	
	@Column(name = "montant")
	private BigDecimal amount;
	
	@Column(name = "periode")
	private String period;
	
	@Column(name = "status")
	private String status;

	public Facture() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	 public void setConvention(Convention convention) {
	     this.convention = convention;
	     this.structure = convention.getStructure();
    }
	public Convention getConvention() {
		return convention;
	}
	public Structure getStructure() {
	    return this.structure;
    }
	public void setStructure(Structure structure) {
		this.structure = structure;
	}

	public LocalDate getDueDatefct() {
		return dueDatefct;
	}
	public void setDueDatefct(LocalDate dueDatefct) {
		this.dueDatefct = dueDatefct;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String string) {
	    this.period = string;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

}







