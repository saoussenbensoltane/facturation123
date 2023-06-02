package com.spring.project.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EtudeBudgetaire implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer numCompte;
	private String typeFinancement;
	private Integer budgetEstimee ;
	private Integer budgetValidee;
	private Date dateDebutMiseEnOeuvre;
	private Integer delaiRealisation;

	@OneToOne
	@JoinColumn(name = "calendrier_id")
	private Calendrier calendrier;


}

