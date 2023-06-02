package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.app.models.User;
import com.app.repository.ConventionRepository;
import com.app.repository.UserRepository;
import com.app.security.jwt.JwtUtils;
import com.app.security.services.ConventionService;

import payload.request.ConventionRequest;
import payload.response.ConventionResponse;

@RestController
@RequestMapping("/api/test/conventions")
public class ConventionController {

	  @Autowired
	    private ConventionService conventionService;
	    
	  @Autowired
	    private JwtUtils jwtUtils;
	
	  @Autowired
	    public ConventionController(ConventionService conventionService) {
	        this.conventionService = conventionService;
	    }
	    
	  @PostMapping("/create")
	  @PreAuthorize("hasRole('ROLE_USER')")
	  public ResponseEntity<ConventionResponse> createConvention(@RequestBody ConventionRequest request, @RequestHeader(name = "Authorization") String token) {
	      Long userId = jwtUtils.getUserIdFromJwtToken(token.substring(7));
	      ConventionResponse response = conventionService.createConvention(request, userId);
	      return ResponseEntity.ok(response);
	  } 
	  
}
