package com.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Convention;
import com.app.models.Facture;
import com.app.models.User;
import com.app.repository.ConventionRepository;
import com.app.security.services.FactureService;
import com.app.security.services.UserDetailsImpl;

import payload.dto.FactureDto;

@RestController
@RequestMapping("/api/test/facture")
public class FactureController {
	
	private FactureService factureService;
    private final ConventionRepository conventionRepository;

    @Autowired
    public FactureController(FactureService factureService, ConventionRepository conventionRepository) {
        this.factureService = factureService;
        this.conventionRepository = conventionRepository;
    }
	
	    @PutMapping("/{factureId}/mark-as-paid")
	    public ResponseEntity<?> markFactureAsPaid(@PathVariable Long factureId) {
	        factureService.markFactureAsPaid(factureId);
	        return ResponseEntity.ok().build();
	    }
	 
	    @GetMapping("/user-convention")
	    @PreAuthorize("hasRole('ROLE_USER')")
	    public ResponseEntity<List<Facture>> getFacturesByUserConvention(Authentication authentication) {
	        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	        List<Facture> factures = factureService.getFacturesByUserConvention(userDetails);
	        return ResponseEntity.ok(factures);
	    }
	    
	   
}
