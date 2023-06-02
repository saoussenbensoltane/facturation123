package com.spring.project.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.project.spring.entities.EtudeBudgetaire;

@Repository
public interface EtudeBudgetaireRepository extends JpaRepository<EtudeBudgetaire, Integer>{

}
