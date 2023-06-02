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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(	name = "convention")
public class Convention {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_id", referencedColumnName = "id")
	private Application application;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "structure_id", referencedColumnName = "id")
	private Structure structure;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@NotNull
	@Column(name = "nbr_reel")
    @JsonProperty("nbr_reel")
	private BigDecimal nbr_reel;
	
	@NotNull
	@Column(name = "nbr_Min")
    @JsonProperty("nbr_Min")
	private BigDecimal nbr_Min;
	
	@NotNull
	@Column(name = "nbr_Max")
    @JsonProperty("nbr_Max")
	private BigDecimal nbr_Max;
	
	@Column(name = "date_signature")
    private LocalDate dateSignature;

	@Column(name = "conventionDuration")
	 private int conventionDuration;
	
	@Transient
    private BigDecimal price;
	
	@Transient
	private String email;
	
	@Column(name = "total_amount")
	@JsonProperty("total_amount")
	private BigDecimal totalAmount;
	
	@Column(name = "date_echeance")
	private LocalDate dueDate;
	
	public Convention () {}
	public Convention(Long id, Application application, Structure structure,User user, @NotNull BigDecimal nbr_reel,
			@NotNull BigDecimal nbr_Min, @NotNull BigDecimal nbr_Max, LocalDate dateSignature, int conventionDuration,
			BigDecimal price,String email, BigDecimal totalAmount) {
		super();
		this.id = id;
		this.application = application;
		this.structure = structure;
		this.user = user;
		this.nbr_reel = nbr_reel;
		this.nbr_Min = nbr_Min;
		this.nbr_Max = nbr_Max;
		this.dateSignature = dateSignature;
		this.conventionDuration = conventionDuration;
		this.price = price;
		this.email=email;
		this.totalAmount = totalAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public Structure getStructure() {
		return structure;
	}
	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BigDecimal getNbr_reel() {
		return nbr_reel;
	}
	public void setNbr_reel(BigDecimal nbr_reel) {
		this.nbr_reel = nbr_reel;
	}
	public BigDecimal getNbr_Min() {
		return nbr_Min;
	}
	public void setNbr_Min(BigDecimal nbr_Min) {
		this.nbr_Min = nbr_Min;
	}
	public BigDecimal getNbr_Max() {
		return nbr_Max;
	}
	public void setNbr_Max(BigDecimal nbr_Max) {
		this.nbr_Max = nbr_Max;
	}
	public LocalDate getDateSignature() {
		return dateSignature;
	}
	public void setDateSignature(LocalDate dateSignature) {
		this.dateSignature = dateSignature;
	}
	public int getConventionDuration() {
		return conventionDuration;
	}
	public void setConventionDuration(int conventionDuration) {
		this.conventionDuration = conventionDuration;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}
