package com.spring.project.spring.entities;

import java.util.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Calendrier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCa;

	private Integer numCompte;
	private Integer coutInitial;
	private Integer coutMisAjour;
	private String responsable;
	private Date dateAgrementSpecifications;
	private Date dateNegociation;
	private Date dateOuvertureSoumission;
	private Date dateTransmissionComite;
	private Date dateReponseCommite;
	private String sujet;
	private boolean selected;

	private String couleur ;
	private Date dateDebutProjet;
	private Date dateAchevemetProjet;
	private boolean budgetSelected;

	@ManyToOne
	private Utilisateur ordo;

	public Utilisateur getOrdo() {
		return ordo;
	}

	@ManyToOne
	private Region reg;
	@ManyToOne
	public TypeAchat TypeA;

	@ManyToOne()
	private NatureProjet natureProjets;

	@OneToOne(mappedBy = "calendrier")
	private FicheTechnique ficheTechnique;

	@OneToOne(mappedBy = "calendrier")
	private EtudeBudgetaire etudeBudgetaire;

}