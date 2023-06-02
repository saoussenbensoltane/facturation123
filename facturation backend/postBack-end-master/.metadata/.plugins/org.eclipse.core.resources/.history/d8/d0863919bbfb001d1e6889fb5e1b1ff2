package com.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.Convention;

@Repository
public interface ConventionRepository extends JpaRepository<Convention, Long> {

	 List<Convention> findByUserId(Long userId);

}