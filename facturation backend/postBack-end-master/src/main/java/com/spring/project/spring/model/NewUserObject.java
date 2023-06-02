package com.spring.project.spring.model;

import com.spring.project.spring.entities.Calendrier;
import com.spring.project.spring.entities.Role;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class NewUserObject {
    private String password;
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
    private Role role;
}
