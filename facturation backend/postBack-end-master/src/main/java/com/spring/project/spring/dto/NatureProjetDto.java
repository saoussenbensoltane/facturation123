package com.spring.project.spring.dto;

import com.spring.project.spring.entities.NatureProjet;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NatureProjetDto {
    private int id;
    private String nature;


    public static NatureProjet toEntity(NatureProjetDto natureProjetDto) {
        if (natureProjetDto == null) {
            return null;
        }
        NatureProjet natureProjet = new NatureProjet();
        natureProjet.setId(natureProjet.getId() != null ? natureProjet.getId() : null);
        natureProjet.setNature(natureProjetDto.getNature());
        return natureProjet;
    }

    public static NatureProjetDto fromEntity(NatureProjet natureProjet) {
        if (natureProjet == null) {
            return null;
        }
        return NatureProjetDto.builder()
                .nature(natureProjet.getNature())
                .id(natureProjet.getId())
                .build();
    }
}