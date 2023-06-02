package com.spring.project.spring.services.impl;

import com.spring.project.spring.dto.NatureProjetDto;

import com.spring.project.spring.entities.DirectionAchat;
import com.spring.project.spring.entities.NatureProjet;
import com.spring.project.spring.exception.ResourceNotFoundException;

import java.util.List;

public interface NatureProjetService {
     NatureProjet addNatureProjet(NatureProjetDto natureProjetDto);
    NatureProjet updateTypeNatureProjet(NatureProjetDto natureProjetDto, int idNatureProjetDto)throws ResourceNotFoundException;
     NatureProjet deleteNatureProjet(int idNatureProjet);
NatureProjetDto findNatureProjetById(int idNatureProjet);
List<NatureProjetDto>getAll();

}


