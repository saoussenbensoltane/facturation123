package com.spring.project.spring.entities;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjetEnCours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String couleur ;
    private Date  dateDebutProjet;
    private Date dateAchevemetProjet;
    private String  status;

}
