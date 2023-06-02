package com.spring.project.spring.services.impl;

import com.spring.project.spring.dto.NatureProjetDto;
import com.spring.project.spring.entities.NatureProjet;

import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.repository.NatureProjetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NatureProjetServImpli implements NatureProjetService{

@Autowired
    NatureProjetRepository NatureProjetRep;
    Logger logger = LoggerFactory.getLogger(NatureProjetServImpli.class);

    @Override
    public NatureProjet addNatureProjet(NatureProjetDto natureProjetDto) {
        System.out.println(natureProjetDto.getNature());
        // TODO Auto-generated method stub
        return NatureProjetRep.save(NatureProjetDto.toEntity(natureProjetDto));

    }

    @Override
    public NatureProjet updateTypeNatureProjet(NatureProjetDto natureProjetDto, int idNatureProjetDto) throws ResourceNotFoundException {
        NatureProjet NaturePro = NatureProjetRep.findById(idNatureProjetDto).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        logger.warn("nature : " + NaturePro.getNature());
        if (NaturePro!= null) {
            NaturePro.setNature(natureProjetDto.getNature());
            return NatureProjetRep.save(NaturePro);
        }
        return NaturePro;
    }

    @Override
    public NatureProjet deleteNatureProjet(int idNatureProjet) {
            // TODO Auto-generated method stub
            NatureProjetRep.deleteById(idNatureProjet);
            return null;


    }

    @Override
    public NatureProjetDto findNatureProjetById(int idNatureProjet) {
        // TODO Auto-generated method stub
        return NatureProjetDto.fromEntity(NatureProjetRep.findById(idNatureProjet).get());
    }

    @Override
    public List<NatureProjetDto> getAll() {
        return NatureProjetRep.findAll().stream().map(NatureProjetDto::fromEntity).collect(Collectors.toList());
    }
}
