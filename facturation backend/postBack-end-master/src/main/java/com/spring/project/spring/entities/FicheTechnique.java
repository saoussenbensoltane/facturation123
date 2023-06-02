package com.spring.project.spring.entities;

import java.io.Serializable;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FicheTechnique implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Long idProjet;
	private String nomChefProjet;
	private String gradeChefProjet;
	private Integer telChefProjet;
	private String emailChefProjet;
	private String nomOrdonnateur;
	private String gradeOrdonnateur;
	private Integer telOrdonnateur;
	private String emailOrdonnateur;
	private String nomRepresentantService;
	private String gradeRepresentantService;
	private Integer telRepresentantService;
	private String emailRepresentantService;

	@OneToOne()
	private EtudeBudgetaire etudeBudgetaire;

	@OneToOne()
	private Calendrier calendrier;

}