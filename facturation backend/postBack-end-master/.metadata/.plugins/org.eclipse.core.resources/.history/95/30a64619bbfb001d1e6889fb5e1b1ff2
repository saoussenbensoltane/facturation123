package com.app.controllers;

import java.util.List;


import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<User> getAllUsers() {
	    return userService.getAllUsers();
	}
	
	@GetMapping("/users/search")
	public ResponseEntity<List<User>> searchUsers(
		    @RequestParam(required = false) String username,
		    @RequestParam(required = false) String email,
		    @RequestParam(required = false) String role) {

		    List<User> users = userService.searchUsers(username, email, role);

		    if (users.isEmpty()) {
		        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No users found");
		    }

		    return ResponseEntity.ok(users);
		}
	
	/*@DeleteMapping("/delete/{id}")
	
	/*public void deleteUserByUsername(@PathVariable String username) {
		userService.deleteUserByUsername(username);
	}
   
	public void deleteExample(@PathVariable Long id) {
		userService.deleteUserById(id);
    }*/
	
	
	@DeleteMapping("/delete/{username}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteUserByUsername(@PathVariable String username) {
		userService.deleteUserByUsername(username);
	}
	@PutMapping("/update/{username}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	}
	
	/*@PutMapping("/update/{id}")
	
	public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody UserUpdateRequest userUpdateRequest) {
	    User userToUpdate = userRepository.findByUsername(username)
	            .orElseThrow(() -> new RuntimeException("Error: username not found."));

	    userToUpdate.setUsername(userUpdateRequest.getUsername());
	    userToUpdate.setEmail(userUpdateRequest.getEmail());
	    userToUpdate.setPassword(encoder.encode(userUpdateRequest.getPassword()));
	    

	    userRepository.save(userToUpdate);

	    return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
	}*/
	
	@PutMapping("/block/{id}")
	public ResponseEntity<?> blockUser(@PathVariable Long id) {
	    Optional<User> userOptional = userRepository.findById(id);
	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        user.setBlocked(true);
	        userRepository.save(user);
	        return ResponseEntity.ok(new MessageResponse("User blocked successfully!"));
	    } else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
	    }
	}
	
	@PutMapping("/unblock/{id}")
	public ResponseEntity<?> unblockUser(@PathVariable Long id) {
	    Optional<User> userOptional = userRepository.findById(id);
	    if (userOptional.isPresent()) {
	        User user = userOptional.get();
	        user.setBlocked(false);
	        userRepository.save(user);
	        return ResponseEntity.ok(new MessageResponse("User unblocked successfully!"));
	    } else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
	    }
	}
	
		}  
		

	
	


