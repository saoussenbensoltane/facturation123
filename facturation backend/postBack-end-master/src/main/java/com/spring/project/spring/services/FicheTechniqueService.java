package com.spring.project.spring.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.project.spring.dto.FichTechniqueDetailsDto;
import com.spring.project.spring.dto.FicheTechniqueDto;
import com.spring.project.spring.entities.FicheTechnique;
import com.spring.project.spring.exception.ResourceNotFoundException;

import java.util.List;

public interface FicheTechniqueService {

 FicheTechnique addfiche(FicheTechniqueDto fiche, int idCal) throws JsonProcessingException;
 FicheTechnique updatefiche(FicheTechniqueDto ficheTechniqueDto, Integer idfiche)
        throws ResourceNotFoundException;
 FicheTechnique deletefiche(Integer idfiche);
 FichTechniqueDetailsDto findFicheTechniqueById(Integer idfiche);
 List<FicheTechniqueDto>getAll();
}



