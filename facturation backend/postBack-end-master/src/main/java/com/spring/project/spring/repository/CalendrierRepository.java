package com.spring.project.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.project.spring.entities.Calendrier;

import java.util.List;

@Repository
public interface CalendrierRepository extends JpaRepository<Calendrier, Integer>{

    List<Calendrier> findCalendrierBySelected(boolean selected);
	

}
