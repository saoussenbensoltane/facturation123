package com.spring.project.spring.repository;


import com.spring.project.spring.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdonnateurRepository  extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findUtilisateurByMatricule(String matricule);

}