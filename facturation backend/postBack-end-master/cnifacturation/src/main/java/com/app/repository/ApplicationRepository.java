package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.models.Application;
@CrossOrigin(origins = "*", maxAge = 3600)

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{
	List<Application> findAll();
	Optional<Application> findById(Long id);
	Optional<Application> findByCode(String code);
	Application findByLibelle(String applicationLibelle);
}
