package com.app.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.models.Application;
import com.app.repository.ApplicationRepository;
import com.app.security.services.ApplicationService;

import payload.request.ApplicatonUpdateRequest;
import payload.request.CreateApplicationRequest;
import payload.response.MessageResponse;

@RestController
@RequestMapping("/api/test/application")
public class ApplicationController {
	@Autowired
	private ApplicationService applicationService ;
	
	@Autowired
	private ApplicationRepository applicationRepository ;
	 
	@PostMapping("/createapp")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createApplication(@RequestBody CreateApplicationRequest request) {
	    Application application = new Application(request.getCode(), request.getLibelle(), request.getPrix());
	    application = applicationService.createApplication(application);
	    return ResponseEntity.ok(new MessageResponse("Application added successfully!"));
	}
	
	@GetMapping("/getall")
	public List<Application> getAllApplications() {
	    return applicationService.getAllApplications();
	}
	
	
@DeleteMapping("/deleteapp/{id}")
@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteExample(@PathVariable Long id) {
	applicationService.deleteApplicationById(id);
    }



@PutMapping("/updateapp/{id}")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public ResponseEntity<?> updateApplication(@PathVariable("id") Long id, @RequestBody ApplicatonUpdateRequest request) {
    Optional<Application> applicationData = applicationRepository.findById(id);

    if (applicationData.isPresent()) {
        Application application = applicationData.get();
        application.setCode(request.getCode());
        application.setLibelle(request.getLibelle());
        application.setPrix(request.getPrix());
        applicationRepository.save(application);
        return ResponseEntity.ok(new MessageResponse("Application updated successfully!"));
    } else {
        return ResponseEntity.badRequest().body(new MessageResponse("Application not found with id: " + id));
    }
}


}
