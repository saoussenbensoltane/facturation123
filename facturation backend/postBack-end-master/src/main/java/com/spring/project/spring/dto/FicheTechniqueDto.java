package com.spring.project.spring.dto;

import com.spring.project.spring.entities.FicheTechnique;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FicheTechniqueDto {
	private  Integer id;
	private Long idProjet;
	private String nomChefProjet;
	private String gradeChefProjet ;
	private Integer telChefProjet ;
	private  String emailChefProjet;
	private String nomOrdonnateur ;
	private String gradeOrdonnateur;
	private Integer telOrdonnateur ;
	private String  emailOrdonnateur;
	private String nomRepresentantService ;
	private String  gradeRepresentantService ;
	private Integer telRepresentantService;
	private String emailRepresentantService ;
	private String natureProjet;
	private String sujetProjet;
	private String typeAchat;
	public static FicheTechnique toEntity (FicheTechniqueDto ficheTechniqueDto)
	{
		if(ficheTechniqueDto == null)
		{
			return null ;
		}
		FicheTechnique ficheTechnique = new FicheTechnique();
		ficheTechnique.setId(ficheTechniqueDto.getId()!=null? ficheTechnique.getId():null);
		ficheTechnique.setNomChefProjet(ficheTechniqueDto.getNomChefProjet());
		ficheTechnique.setGradeChefProjet(ficheTechniqueDto.getGradeChefProjet());
		ficheTechnique.setTelChefProjet(ficheTechniqueDto.getTelChefProjet());
		ficheTechnique.setEmailChefProjet(ficheTechniqueDto.getEmailChefProjet());
		ficheTechnique.setNomOrdonnateur(ficheTechniqueDto.getNomOrdonnateur());
		ficheTechnique.setGradeOrdonnateur(ficheTechniqueDto.getGradeOrdonnateur());
		ficheTechnique.setTelOrdonnateur(ficheTechniqueDto.getTelOrdonnateur());
		ficheTechnique.setEmailOrdonnateur(ficheTechniqueDto.getEmailOrdonnateur());
		ficheTechnique.setNomRepresentantService(ficheTechniqueDto.getNomRepresentantService());
		ficheTechnique.setGradeRepresentantService(ficheTechniqueDto.getGradeRepresentantService());
		ficheTechnique.setTelRepresentantService(ficheTechniqueDto.getTelRepresentantService());
		ficheTechnique.setEmailRepresentantService(ficheTechniqueDto.getEmailRepresentantService());
		return ficheTechnique;

	}
	public static FicheTechniqueDto formEntity(FicheTechnique ficheTechnique)
	{
		if(ficheTechnique== null)
		{
			return null ;
		}
		return FicheTechniqueDto.builder()
				.id(ficheTechnique.getId())
				.nomChefProjet(ficheTechnique.getNomChefProjet())
				.gradeChefProjet(ficheTechnique.getGradeChefProjet())
				.telChefProjet(ficheTechnique.getTelChefProjet())
				.emailChefProjet(ficheTechnique.getEmailChefProjet())
				.nomOrdonnateur(ficheTechnique.getNomOrdonnateur())
				.gradeOrdonnateur(ficheTechnique.getGradeOrdonnateur())
				.telOrdonnateur(ficheTechnique.getTelOrdonnateur())
				.emailOrdonnateur(ficheTechnique.getEmailOrdonnateur())
				.nomRepresentantService(ficheTechnique.getNomRepresentantService())
				.gradeRepresentantService(ficheTechnique.getGradeRepresentantService())
				.telRepresentantService(ficheTechnique.getTelRepresentantService())
				.emailRepresentantService(ficheTechnique.getEmailRepresentantService())
				.natureProjet(ficheTechnique.getCalendrier().getNatureProjets().getNature())
				.sujetProjet(ficheTechnique.getCalendrier().getSujet())
				.typeAchat(ficheTechnique.getCalendrier().getTypeA().getAchatType())
				.build();

	}

















}