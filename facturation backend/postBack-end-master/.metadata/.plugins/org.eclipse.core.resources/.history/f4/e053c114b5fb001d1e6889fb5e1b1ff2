package com.app.controllers;

import java.util.List;

import java.util.Optional;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.models.User;
import com.app.repository.UserRepository;
import com.app.security.services.UserService;

import payload.request.UserUpdateRequest;
import payload.response.MessageResponse;
@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/api/test")

public class UserController {
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	PasswordEncoder encoder;
	

	@GetMapping("/get")
	
	public List<User> getAllUsers() {
	    return userService.getAllUsers();
	}
	
	@DeleteMapping("/delete/{username}")
	public void deleteUserByUsername(@PathVariable String username) {
		userService.deleteUserByUsername(username);
	}
   /* public void deleteExample(@PathVariable Long id) {
		userService.deleteUserById(id);
    }*/
	
	
	
	@PutMapping("/update/{username}")
	public ResponseEntity<?> updateUser(@PathVariable("username") String username, @RequestBody UserUpdateRequest userUpdateRequest) {
	    User userToUpdate = userRepository.findByUsername(username)
	            .orElseThrow(() -> new RuntimeException("Error: username not found."));

	    userToUpdate.setUsername(userUpdateRequest.getUsername());
	    userToUpdate.setEmail(userUpdateRequest.getEmail());
	    
	    String rawPassword = userUpdateRequest.getPassword();
	    if (rawPassword != null) {
	        userToUpdate.setPassword(encoder.encode(rawPassword));
	    }

	    userRepository.save(userToUpdate);

	    return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
	}}


	
	


