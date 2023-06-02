package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long>{
	List<Facture> findByStatus(String status);
}
