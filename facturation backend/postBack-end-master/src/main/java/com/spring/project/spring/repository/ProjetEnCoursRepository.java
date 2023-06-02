package com.spring.project.spring.repository;
import com.spring.project.spring.entities.ProjetEnCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProjetEnCoursRepository extends JpaRepository<ProjetEnCours,Long> {


}
