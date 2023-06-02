package com.spring.project.spring.repository;

import com.spring.project.spring.entities.NatureProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatureProjetRepository extends JpaRepository<NatureProjet,Integer> {
}
