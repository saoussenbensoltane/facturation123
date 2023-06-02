package com.spring.project.spring.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.project.spring.dto.UtilisateurDto;
import com.spring.project.spring.entities.Utilisateur;
import com.spring.project.spring.exception.ResourceNotFoundException;

import java.util.List;

public interface OrdonnateurService {
   Utilisateur addordonnateur(String utilisateur, String role) throws JsonProcessingException;


     Utilisateur updateordonnateur(UtilisateurDto utilisateurDto, int idordonnateurDto)
            throws ResourceNotFoundException;

   Utilisateur deleteordonnateur(int idordonnateur);

    UtilisateurDto findOrdonnateurById(int idOrdonnateur);

    List<UtilisateurDto>getAll();
    Utilisateur getUserByMatricule(String matricule);
}
