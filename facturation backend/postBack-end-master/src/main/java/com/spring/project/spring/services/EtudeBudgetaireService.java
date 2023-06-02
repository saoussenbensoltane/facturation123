package com.spring.project.spring.services;
import com.spring.project.spring.dto.EtudeBudgetaireDto;
import com.spring.project.spring.entities.EtudeBudgetaire;
import com.spring.project.spring.exception.ResourceNotFoundException;

import java.util.List;

public interface EtudeBudgetaireService {
     EtudeBudgetaire addBudget(EtudeBudgetaireDto etudeBudgetaireDto);
     EtudeBudgetaire updatebudget (EtudeBudgetaireDto etudeBudgetaireDto, int idbudgetDto)
            throws ResourceNotFoundException;
     EtudeBudgetaire deletebudget(int idbudget);
     EtudeBudgetaireDto findBudgetById(int idbudget);

     List<EtudeBudgetaireDto> getAll();




}
