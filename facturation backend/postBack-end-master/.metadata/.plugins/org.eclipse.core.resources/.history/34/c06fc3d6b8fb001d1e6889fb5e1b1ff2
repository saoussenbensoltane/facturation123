package com.app.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.Convention;
import com.app.models.Facture;
import com.app.models.User;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
	
    List<Facture> findByStatus(String status);
    List<Facture> findByDueDatefct(LocalDate dueDatefct);
    List<Facture> findByConventionUserAndConventionUser_Id(User user, Long userId);
    @EntityGraph(attributePaths = {"convention", "convention.application", "convention.structure", "convention.user"})
    List<Facture> findByConventionUser(User user);
	List<Facture> findByConvention(Convention convention);
    }
