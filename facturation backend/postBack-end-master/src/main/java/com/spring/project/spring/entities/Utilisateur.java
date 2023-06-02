package com.spring.project.spring.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ;
	private String password;

	@Column(name = "matricule", unique = true)
	private String matricule;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;

	@OneToMany(mappedBy = "ordo")
	private List<Calendrier> calendriers;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<>();

}
