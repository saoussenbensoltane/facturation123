package com.spring.project.spring.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.spring.dto.CalendrierDto;
import com.spring.project.spring.dto.FichTechniqueDetailsDto;
import com.spring.project.spring.dto.RegionDto;
import com.spring.project.spring.entities.Calendrier;
import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.repository.CalendrierRepository;
import com.spring.project.spring.repository.RegionRepository;
import com.spring.project.spring.services.FicheTechniqueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.spring.dto.FicheTechniqueDto;
import com.spring.project.spring.entities.FicheTechnique;
import com.spring.project.spring.repository.FicheTechniqueRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FicheTechniqueTechniqueServiceimpli implements FicheTechniqueService {
	@Autowired
    FicheTechniqueRepository ficheRep;

    @Autowired
    CalendrierRepository calendrierRepository;
	Logger logger = LoggerFactory.getLogger(FicheTechniqueTechniqueServiceimpli.class);

	@Override
	public FicheTechnique addfiche(FicheTechniqueDto fiche, int idCal) throws JsonProcessingException {
        FicheTechnique ficheTechnique = FicheTechniqueDto.toEntity(fiche);
        ficheTechnique.setCalendrier(this.calendrierRepository.findById(idCal).get());
        ficheTechnique.setIdProjet(Integer.toUnsignedLong(idCal));
		// TODO Auto-generated method stub
		ficheRep.save(ficheTechnique);
		
		return null;
	}
    @Override
    public FicheTechnique updatefiche(FicheTechniqueDto ficheTechniqueDto, Integer idficheDto) throws ResourceNotFoundException {
        // TODO Auto-generated method stub

        FicheTechnique fich = ficheRep.findById(idficheDto).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        logger.warn("nomchef : " + fich.getNomChefProjet());
        if (fich != null) {
            fich.setNomChefProjet(ficheTechniqueDto.getNomChefProjet());
            fich.setIdProjet(ficheTechniqueDto.getIdProjet());
            fich.setNomChefProjet(ficheTechniqueDto.getNomChefProjet());
            fich.setGradeChefProjet(ficheTechniqueDto.getGradeChefProjet());
            fich.setTelChefProjet(ficheTechniqueDto.getTelChefProjet());
            fich.setEmailChefProjet(ficheTechniqueDto.getEmailChefProjet());
            fich.setNomOrdonnateur(ficheTechniqueDto.getNomOrdonnateur());
            fich.setGradeOrdonnateur(ficheTechniqueDto.getGradeOrdonnateur());
            fich.setTelOrdonnateur(ficheTechniqueDto.getTelOrdonnateur());
            fich.setEmailOrdonnateur(ficheTechniqueDto.getEmailOrdonnateur());
            fich.setNomRepresentantService(ficheTechniqueDto.getNomRepresentantService());
            fich.setGradeRepresentantService(ficheTechniqueDto.getGradeRepresentantService());
            fich.setTelRepresentantService(ficheTechniqueDto.getTelRepresentantService());
            fich.setEmailRepresentantService(ficheTechniqueDto.getEmailRepresentantService());
            return ficheRep.save(fich);
        }
        return fich;
    }
    @Override
        public FicheTechnique deletefiche(Integer idfiche) {
        // TODO Auto-generated method stub
       ficheRep.deleteById(idfiche);
        return null;

    }

    @Override
    public FichTechniqueDetailsDto findFicheTechniqueById(Integer idfiche) {
        // TODO Auto-generated method stub

        return FichTechniqueDetailsDto.formEntity(ficheRep.findById(idfiche).get());
    }

    @Override
    public List<FicheTechniqueDto> getAll() {
        return ficheRep.findAll().stream().map(FicheTechniqueDto::formEntity).collect(Collectors.toList());
    }


}
