package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.security.services.ConventionService;

import payload.request.ConventionRequest;
import payload.response.ConventionResponse;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/conventions")
public class ConventionController {

	  @Autowired
	    private ConventionService conventionService;
	
	  @Autowired
	    public ConventionController(ConventionService conventionService) {
	        this.conventionService = conventionService;
	    }
	    
	  @PostMapping("/create")
	    public ResponseEntity<ConventionResponse> createConvention(@RequestBody ConventionRequest request) {
	        ConventionResponse response = conventionService.createConvention(request);
	        return ResponseEntity.ok(response);
	    }
	  
	  
}
