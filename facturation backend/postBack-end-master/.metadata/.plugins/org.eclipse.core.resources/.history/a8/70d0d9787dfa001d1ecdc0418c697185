package com.app.security.services;


import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.models.Application;
import com.app.models.Convention;
import com.app.models.Structure;
import com.app.repository.ApplicationRepository;
import com.app.repository.ConventionRepository;
import com.app.repository.StructureRepository;

import payload.request.ConventionRequest;
import payload.response.ConventionResponse;

@Service
public class ConventionService {
	@Autowired 
	ConventionRepository conventionRepo;
	private final ConventionRepository conventionRepository;
	
    @Autowired
    private ApplicationRepository applicationRepository;
    
    @Autowired
    private StructureRepository structureRepository;
   
    @Autowired
    private FactureService factureService;
    
    
       
    public ConventionService(ConventionRepository conventionRepository) {
        this.conventionRepository = conventionRepository;
    }
    
    public ConventionResponse createConvention(ConventionRequest request) {
        String applicationLibelle = request.getApplication();
        String structureLibelle = request.getStructure();
    	
        Application application = Optional.ofNullable(applicationRepository.findByLibelle(applicationLibelle))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found"));

        Structure structure = Optional.ofNullable(structureRepository.findByLibelle(structureLibelle))
        	    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Structure not found"));

        BigDecimal nbr_reel = request.getNbr_reel();
        BigDecimal nbr_Min = request.getNbr_Min();
        BigDecimal nbr_Max = request.getNbr_Max();
        
        if (nbr_Min == null) {
            throw new IllegalArgumentException("Minimum value cannot be null");
        }

        if (nbr_Min.compareTo(BigDecimal.valueOf(15)) < 0) {
            throw new IllegalArgumentException("Minimum value cannot be less than 15: " + nbr_Min);
        }

        if (nbr_Max.compareTo(BigDecimal.valueOf(30)) > 0) {
            throw new IllegalArgumentException("Maximum value cannot be greater than 30: " + nbr_Max);
        }

        if (nbr_Max.compareTo(BigDecimal.valueOf(30)) > 0) {
            throw new IllegalArgumentException("Maximum value cannot be greater than 30: " + nbr_Max);
        }
        
        Convention convention = new Convention();
        convention.setApplication(application);
        convention.setStructure(structure);
        convention.setNbr_Min(nbr_Min);
        convention.setNbr_Max(nbr_Max);
        convention.setNbr_reel(nbr_reel);
        convention.setTotalAmount(request.getNbr_reel().multiply(application.getPrix()));
        convention.setConventionDuration(request.getConventionDuration());
        LocalDate date = request.getDateSignature();
        convention.setDateSignature(date);
        LocalDate dueDate = request.getDateSignature().plusYears(request.getConventionDuration());
        convention.setDueDate(dueDate);
        
        
        
        convention = conventionRepository.save(convention);
        factureService.createFacturesForConvention(convention);
        
        
        ConventionResponse response = new ConventionResponse(
        	    application.getCode(),
        	    structure.getLibelle(),
        	    application.getPrix(),
        	    request.getNbr_reel(),
        	    convention.getTotalAmount(),
        	    convention.getNbr_Min(),
        	    convention.getNbr_Max(),
        	    convention.getDateSignature(),
        	    dueDate 
        	);        
        	return response;
    }
}
