package com.spring.project.spring.entities;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NatureProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String nature ;

    @OneToMany(mappedBy = "natureProjets",fetch = FetchType.LAZY)
    private List<Calendrier> calendrier;
}
