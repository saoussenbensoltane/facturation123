package com.spring.project.spring.dto;

import com.spring.project.spring.entities.EtudeBudgetaire;
import lombok.*;

import java.util.Date;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EtudeBudgetaireDto {
    private Integer id;
    private  int numCompte;
    private String  typeFinancement;
    private int budgetEstimee;
    private int  budgetValidee;
    private Date  dateDebutMiseEnOeuvre;
    private int delaiRealisation;
    private int id_projet;
    private String sujetProjet;
    private String natureProjet;
    private int region;
    private int natureProjetId;
    private String ordonnateur;
    private String nomChefProjet;
    private String nomRepresentantService;
    private String nomRepOrdonnateur;
    private CalendrierDto calendrierDto;
    public static EtudeBudgetaire toEntity(EtudeBudgetaireDto etudeBudgetaireDto) {
        if (etudeBudgetaireDto == null) {
            return null;
        }

        EtudeBudgetaire budget = new EtudeBudgetaire();
        budget.setId(etudeBudgetaireDto.getId() != null ? budget.getId() : null);
        budget.setNumCompte(etudeBudgetaireDto.getNumCompte());
        budget.setTypeFinancement(etudeBudgetaireDto.getTypeFinancement());
        budget.setBudgetEstimee(etudeBudgetaireDto.getBudgetEstimee());
        budget.setBudgetValidee(etudeBudgetaireDto.getBudgetValidee());
        budget.setDateDebutMiseEnOeuvre(etudeBudgetaireDto.getDateDebutMiseEnOeuvre());
        budget.setDelaiRealisation(etudeBudgetaireDto.getDelaiRealisation());


return budget;
    }

    public static EtudeBudgetaireDto fromEntity(EtudeBudgetaire etudeBudgetaire) {
        if (etudeBudgetaire == null) {
            return null;
        }

        return EtudeBudgetaireDto.builder()
                                .id(etudeBudgetaire.getId())
                                .numCompte(etudeBudgetaire.getNumCompte())
                                .typeFinancement(etudeBudgetaire.getTypeFinancement())
                                .budgetEstimee(etudeBudgetaire.getBudgetEstimee())
                                .budgetValidee(etudeBudgetaire.getBudgetValidee())
                                .dateDebutMiseEnOeuvre(etudeBudgetaire.getDateDebutMiseEnOeuvre())
                                .delaiRealisation(etudeBudgetaire.getDelaiRealisation())
                .id_projet(etudeBudgetaire.getCalendrier().getIdCa())
                .sujetProjet(etudeBudgetaire.getCalendrier().getSujet())
                .natureProjet(etudeBudgetaire.getCalendrier().getNatureProjets().getNature())
                .region(etudeBudgetaire.getCalendrier().getReg().getId())
                .natureProjetId(etudeBudgetaire.getCalendrier().getNatureProjets().getId())
                .ordonnateur(etudeBudgetaire.getCalendrier().getOrdo().getNom())
                .nomRepOrdonnateur(etudeBudgetaire.getCalendrier().getFicheTechnique().getNomOrdonnateur())
                .nomChefProjet(etudeBudgetaire.getCalendrier().getFicheTechnique().getNomChefProjet())
                .nomRepresentantService(etudeBudgetaire.getCalendrier().getFicheTechnique().getNomRepresentantService())
                .calendrierDto(CalendrierDto.fromEntity(etudeBudgetaire.getCalendrier()))
                                  .build();

    }
}
