package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.security.services.FactureService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/facture")
public class FactureController {
	 @Autowired
	    private FactureService factureService;
	
	  @Autowired
	    public FactureController(FactureService factureService) {
	        this.factureService = factureService;
	    }
	
	 @PreAuthorize("hasRole('ADMIN')")
	    @PutMapping("/{factureId}/mark-as-paid")
	    public ResponseEntity<?> markFactureAsPaid(@PathVariable Long factureId) {
	        factureService.markFactureAsPaid(factureId);
	        return ResponseEntity.ok().build();
	    }
}
//******
