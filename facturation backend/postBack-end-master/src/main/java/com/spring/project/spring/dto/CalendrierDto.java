package com.spring.project.spring.dto;

import java.util.Date;

import com.spring.project.spring.entities.Calendrier;

import com.spring.project.spring.entities.RoleNameOrdo;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalendrierDto {
	private Integer idCa;
	private String sujet;
	private Integer numCompte;
   	private Integer coutInitial ;
   	private Integer coutMisAjour;
  	private String  responsable;
  	private Date  dateAgrementSpecifications;
  	private Date dateNegociation;
  	private Date dateOuvertureSoumission;
  	private Date  dateTransmissionComite ;
  	private Date   dateReponseCommite;
	  private int region;
	  private String ordonnateur;
	  private int natureprojet;
	private boolean selected;
	private int typeA;
	private String typeAchat;

	private String couleur ;
	private Date dateDebutProjet;
	private Date dateAchevemetProjet;
	private boolean	budgetSelected;
	private String natureProjectName;
	private String nomRepOrdonnateur;
	private String nomChefProjet;
	private String nomRepresentantService;
	private boolean selectedFiche;


	public static Calendrier toEntity (CalendrierDto calendrierDto)
{
	if(calendrierDto == null)
	{
		return null ;
	}
	Calendrier calendrier= new Calendrier();
	calendrier.setIdCa(calendrier.getIdCa() != null ? calendrier.getIdCa() : null);

	calendrier.setNumCompte(calendrierDto.getNumCompte());
	calendrier.setCoutInitial(calendrierDto.getCoutInitial());
	calendrier.setCoutMisAjour(calendrierDto.getCoutMisAjour());
	calendrier.setResponsable(calendrierDto.getResponsable());
	calendrier.setDateAgrementSpecifications(calendrierDto.getDateAgrementSpecifications());
	calendrier.setDateNegociation(calendrierDto.getDateNegociation());
	calendrier.setDateOuvertureSoumission(calendrierDto.getDateOuvertureSoumission());
	calendrier.setDateTransmissionComite(calendrierDto.getDateTransmissionComite());
	calendrier.setDateReponseCommite(calendrierDto.getDateReponseCommite());
	calendrier.setSujet(calendrierDto.getSujet());
	calendrier.setSelected(calendrierDto.isSelected());
	return calendrier ;

}
	public static CalendrierDto fromEntity(Calendrier calendrier) {
		if (calendrier == null) {
			return null;
		}
		return CalendrierDto.builder()
				.idCa(calendrier.getIdCa())
				.numCompte(calendrier.getNumCompte())
				.coutInitial(calendrier.getCoutInitial())
				.coutMisAjour(calendrier.getCoutMisAjour())
				.responsable(calendrier.getResponsable())
				.dateAgrementSpecifications(calendrier.getDateAgrementSpecifications())
				.dateNegociation(calendrier.getDateNegociation())
				.dateOuvertureSoumission(calendrier.getDateOuvertureSoumission())
				.dateTransmissionComite(calendrier.getDateTransmissionComite())
				.dateReponseCommite(calendrier.getDateReponseCommite())
				.sujet(calendrier.getSujet())
				.region(calendrier.getReg().getId())
				.ordonnateur(calendrier.getOrdo().getNom())
				.natureprojet(calendrier.getNatureProjets().getId())
				.selected(calendrier.isSelected())
				.couleur(calendrier.getCouleur())
				.dateDebutProjet(calendrier.getDateDebutProjet())
				.dateAchevemetProjet(calendrier.getDateAchevemetProjet())
				.typeA(calendrier.getTypeA().getId())
				.typeAchat(calendrier.getTypeA().getAchatType())
				.budgetSelected(calendrier.isBudgetSelected())
				.natureProjectName(calendrier.getNatureProjets().getNature())
				.nomRepOrdonnateur(calendrier.getFicheTechnique() != null ? calendrier.getFicheTechnique().getNomOrdonnateur(): null)
				.nomRepresentantService(calendrier.getFicheTechnique()!=null ? calendrier.getFicheTechnique().getNomRepresentantService(): null)
				.nomChefProjet(calendrier.getFicheTechnique()!=null ? calendrier.getFicheTechnique().getNomChefProjet(): null)
				.selectedFiche((calendrier.getFicheTechnique()!=null? true: false))
				.build();
	}}
