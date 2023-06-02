package com.spring.project.spring.services.impl;

import com.spring.project.spring.dto.EtudeBudgetaireDto;
import com.spring.project.spring.entities.Calendrier;
import com.spring.project.spring.entities.EtudeBudgetaire;
import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.repository.CalendrierRepository;
import com.spring.project.spring.services.EtudeBudgetaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.spring.repository.EtudeBudgetaireRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtudeBudgetaireServiceImli implements EtudeBudgetaireService {
    @Autowired
    EtudeBudgetaireRepository budgetRep;

    @Autowired
    CalendrierRepository calendrierRepository;
    Logger logger = LoggerFactory.getLogger(EtudeBudgetaireServiceImli.class);

    @Override
    public EtudeBudgetaire addBudget(EtudeBudgetaireDto etudeBudgetaireDto) {
        System.out.println(etudeBudgetaireDto.getId_projet());
        EtudeBudgetaire etudeBudgetaire = EtudeBudgetaireDto.toEntity(etudeBudgetaireDto);
        Calendrier calendrier = this.calendrierRepository.findById(etudeBudgetaireDto.getId_projet()).get();
        calendrier.setBudgetSelected(true);
        etudeBudgetaire.setCalendrier(calendrier);
        // TODO Auto-generated method stub
        budgetRep.save(etudeBudgetaire);
        return null;
    }

    @Override
    public EtudeBudgetaire updatebudget(EtudeBudgetaireDto etudeBudgetaireDto, int idbudgetDto) throws ResourceNotFoundException {
        // TODO Auto-generated method stub

        EtudeBudgetaire bud = budgetRep.findById(idbudgetDto).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        logger.warn(" NumCompte: " + bud.getNumCompte());
        if (bud != null) {
            bud.setNumCompte(etudeBudgetaireDto.getNumCompte());
            bud.setTypeFinancement(etudeBudgetaireDto.getTypeFinancement());
            bud.setBudgetEstimee(etudeBudgetaireDto.getBudgetEstimee());
            bud.setBudgetValidee(etudeBudgetaireDto.getBudgetValidee());
            bud.setDateDebutMiseEnOeuvre(etudeBudgetaireDto.getDateDebutMiseEnOeuvre());
            bud.setDelaiRealisation(etudeBudgetaireDto.getDelaiRealisation());
            return budgetRep.save(bud);
        }
        return bud;
    }

    @Override
    public EtudeBudgetaire deletebudget(int idbudgetDto) {
        // TODO Auto-generated method stub
        budgetRep.deleteById(idbudgetDto);
        return null;
    }

    @Override
    public EtudeBudgetaireDto findBudgetById(int idbudget) {
        // TODO Auto-generated method stub
       return EtudeBudgetaireDto.fromEntity(budgetRep.findById(idbudget).get()) ;
    }

    @Override
    public List<EtudeBudgetaireDto> getAll() {
        return budgetRep.findAll().stream().map(EtudeBudgetaireDto::fromEntity).collect(Collectors.toList());
    }
}