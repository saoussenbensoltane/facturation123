package com.spring.project.spring.services.impl;

import com.spring.project.spring.dto.ProjetEnCoursDto;
import com.spring.project.spring.entities.ProjetEnCours;
import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.repository.ProjetEnCoursRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetEnCoursServiceImpl implements ProjetEnCoursService {
    @Autowired
    ProjetEnCoursRepository projetEnCoursRep;
    Logger logger = LoggerFactory.getLogger(ProjetEnCoursServiceImpl.class);

    @Override
    public ProjetEnCours addProjetEnCours(ProjetEnCoursDto projetEnCoursDto) {
        // TODO Auto-generated method stub
        projetEnCoursRep.save(ProjetEnCoursDto.toEntity(projetEnCoursDto));
        return null;
    }

    @Override
    public ProjetEnCours updateProjetEnCours(ProjetEnCoursDto projetEnCoursDto, Long idProjetEnCoursDto) throws ResourceNotFoundException {
        	// TODO Auto-generated method stub
ProjetEnCours projetEn=projetEnCoursRep.findById(idProjetEnCoursDto).orElseThrow(()->new ResourceNotFoundException("not found"));
		logger.warn(" couleur:"+projetEn.getCouleur());
        if ( projetEn!=null){
            projetEn.setCouleur(projetEnCoursDto.getCouleur());
            return projetEnCoursRep.save(projetEn);
        }
        return null;
    }

    @Override
    public ProjetEnCours deleteProjetEnCours(Long idProjetEnCours) {
        // TODO Auto-generated method stub
        projetEnCoursRep.deleteById(idProjetEnCours);
        return null;
    }
//
    @Override
    public List<ProjetEnCoursDto> getAll() {
        return projetEnCoursRep.findAll().stream().map(ProjetEnCoursDto::fromEntity).collect(Collectors.toList());
    }
}