package com.spring.project.spring.services.impl;

import com.spring.project.spring.dto.ProjetEnCoursDto;
import com.spring.project.spring.entities.ProjetEnCours;
import com.spring.project.spring.exception.ResourceNotFoundException;

import java.util.List;

public interface ProjetEnCoursService {

    ProjetEnCours addProjetEnCours(ProjetEnCoursDto projetEnCoursDto);

ProjetEnCours updateProjetEnCours(ProjetEnCoursDto projetEnCoursDto,Long idProjetEnCoursDto)throws ResourceNotFoundException;


ProjetEnCours deleteProjetEnCours(Long idProjetEnCours);

List<ProjetEnCoursDto>getAll();
}