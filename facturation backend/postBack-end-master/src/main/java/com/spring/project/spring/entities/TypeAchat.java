package com.spring.project.spring.entities;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private  String achatType ;

    @OneToMany(mappedBy = "TypeA")
    private List<Calendrier>calendriers;

}
