package com.app.security.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.app.models.Application;
import com.app.repository.ApplicationRepository;

@Service
@Transactional
public class ApplicationService {
	
	@Autowired 
	ApplicationRepository applicationRepo;
	private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

	public List<Application> getAllApplications() {
		return applicationRepository.findAll();
	}

	public void deleteApplicationById(Long appId) {
		Optional<Application> application = applicationRepo.findById(appId);
	    if (application.isPresent()) {
	        applicationRepo.deleteById(appId);
	        
	}else {
	    throw new UsernameNotFoundException("Application not found with id: " + appId);
	}
	
	}
	public void updateApplication(String code, String libelle, String sujet, BigDecimal prix, Long id) {
	    Optional<Application> applicationOptional = applicationRepository.findById(id);
	    if (applicationOptional.isPresent()) {
	        Application application = applicationOptional.get();
	        application.setCode(code);
	        application.setLibelle(libelle);
	        application.setPrix(prix);
	        applicationRepository.save(application);
	    } else {
	    	  throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found");
	    }
	}
	
	
}
