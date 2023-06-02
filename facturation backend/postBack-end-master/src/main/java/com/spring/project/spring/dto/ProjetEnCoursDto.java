package com.spring.project.spring.dto;

import com.spring.project.spring.entities.ProjetEnCours;
import lombok.*;

import java.util.Date;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetEnCoursDto {
    private Integer id;
    private String couleur ;
    private Date dateDebutProjet;
    private Date dateAchevemetProjet;
    private String  status;

    //public static Utilisateur toEntity (UtilisateurDto ordonnateurDto)
    //	{
    //		if(ordonnateurDto == null)
    //		{
    //			return null ;
    //		}
    //
    //		Utilisateur ordonnateur = new Utilisateur();
    //		ordonnateur.setId(ordonnateurDto.getId() != null ? ordonnateurDto.getId() : null);
    //		ordonnateur.setMatricule(ordonnateurDto.getMatricule());
    //		ordonnateur.setPassword(ordonnateurDto.getPassword());
    //		return ordonnateur ;
    //
    //	}
    public static ProjetEnCours toEntity(ProjetEnCoursDto projetEnCoursDto) {
        if (projetEnCoursDto == null) {
            return null;
        }
        ProjetEnCours projetEnCours = new ProjetEnCours();
        projetEnCours.setId(projetEnCoursDto.getId()!= null ? projetEnCours.getId() : null);
        projetEnCours.setCouleur(projetEnCoursDto.getCouleur() );
        projetEnCours.setDateDebutProjet(projetEnCoursDto.getDateDebutProjet());
        projetEnCours.setDateAchevemetProjet(projetEnCoursDto.getDateAchevemetProjet());
        projetEnCours.setStatus(projetEnCoursDto.getStatus());
        return projetEnCours;
    }


public static ProjetEnCoursDto fromEntity(ProjetEnCours projetEnCours){
     if (projetEnCours==null) {
         return null;
      }
      return ProjetEnCoursDto.builder().build().builder()
              .id(projetEnCours.getId())
              .couleur(projetEnCours.getCouleur())
              .dateDebutProjet(projetEnCours.getDateDebutProjet())
               .dateAchevemetProjet(projetEnCours.getDateAchevemetProjet())
               .status(projetEnCours.getStatus())
               .build();}}

