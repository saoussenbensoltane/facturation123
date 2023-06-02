package com.spring.project.spring.dto;

import com.spring.project.spring.entities.Utilisateur;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDto {
	private Integer id;
	private String matricule ;
	private String password ;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;

	public static Utilisateur toEntity (UtilisateurDto utilisateurDto)
	{
		if(utilisateurDto == null)
		{
			return null ;
		}

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(utilisateurDto.getId() != null ? utilisateurDto.getId() : null);
		utilisateur.setMatricule(utilisateurDto.getMatricule());
		utilisateur.setPassword(utilisateurDto.getPassword());
		utilisateur.setNom(utilisateurDto.getNom());
		utilisateur.setPrenom(utilisateurDto.getPrenom());
		utilisateur.setEmail(utilisateurDto.getEmail());
		utilisateur.setEmail(utilisateurDto.getEmail());
		return utilisateur;

	}
	public static UtilisateurDto fromEntity(Utilisateur utilisateur)
	{
		if(utilisateur == null)
		{
			return null ;
		}
return UtilisateurDto.builder()

		.id(utilisateur.getId() )
		.matricule(utilisateur.getMatricule())
		.password(utilisateur.getPassword())
		.telephone(utilisateur.getTelephone())
		.email(utilisateur.getEmail())
		.nom(utilisateur.getNom())
		.prenom(utilisateur.getPrenom())
		.build();
	}
}
