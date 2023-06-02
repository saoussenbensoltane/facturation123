package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
	Optional<User> findById(Long id) ;
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	void deleteById(Long id);
	Optional<User> findByEmail(String email);
	List<User> findByRolesContainingIgnoreCase(String role);
	 List<User> findAll();
	
}
