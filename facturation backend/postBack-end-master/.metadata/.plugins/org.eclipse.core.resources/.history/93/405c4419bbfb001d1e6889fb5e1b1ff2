package com.app.controllers;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.Structure;
import com.app.security.services.StructureService;


    @RestController
    @RequestMapping("api/test/structures")
    public class StructureController {
    	 private final StructureService structureService;

    	    public StructureController(StructureService structureService) {
    	        this.structureService = structureService;
    	    }
    	    
        @PostMapping("/create")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<Structure> createStructure(@RequestBody Structure newStructure) {
            Structure createdStructure = structureService.createStructure(newStructure);
            return ResponseEntity.ok(createdStructure);
        }

        @GetMapping("/without-ministere")
        public ResponseEntity<List<Structure>> getStructuresWithoutMinistere() {
            List<Structure> structures = structureService.getStructuresWithNullMinistere();
            return ResponseEntity.ok(structures);
        }

        @GetMapping("/with-ministere")
        public ResponseEntity<List<Structure>> getStructuresWithMinistere() {
            List<Structure> structures = structureService.getStructuresWithMinistere();
            return ResponseEntity.ok(structures);
        }
        
        @DeleteMapping("/delete-child/{id}")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<?> deleteChildStructure(@PathVariable Long id) {
            structureService.deleteChildStructureById(id);
            return ResponseEntity.ok().build();
        }
        
        @PutMapping("/{id}")
        @PreAuthorize("hasRole('ROLE_ADMIN')")
        public ResponseEntity<Structure> updateStructure(@PathVariable Long id, @RequestBody Structure updatedStructure) {
            Structure result = structureService.updateStructure(id, updatedStructure);
            return ResponseEntity.ok(result);
        }
        
       /* @PostMapping("/create")
        public ResponseEntity<Structure> createStructure(@RequestBody CreateStructureRequest request) {
            Structure newStructure = new Structure(null, request.getCode(), request.getLibelle(), request.getId_ministere());
            newStructure = structureService.createStructure(newStructure);
            return ResponseEntity.status(HttpStatus.CREATED).body(newStructure);
        }*/
    }
 
    
    

