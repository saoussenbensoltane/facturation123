package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{
	List<Application> findAll();
	Optional<Application> findById(Long id);
	Optional<Application> findByCode(String code);
	Application findByLibelle(String applicationLibelle);
}
