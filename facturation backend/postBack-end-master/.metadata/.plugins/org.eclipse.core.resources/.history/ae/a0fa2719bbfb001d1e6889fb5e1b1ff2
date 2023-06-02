package com.app.security.services;


import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.models.Application;
import com.app.models.Convention;
import com.app.models.Structure;
import com.app.models.User;
import com.app.repository.ApplicationRepository;
import com.app.repository.ConventionRepository;
import com.app.repository.StructureRepository;
import com.app.repository.UserRepository;
import com.app.security.jwt.JwtUtils;

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
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
	private JwtUtils jwtUtils;
    
    public ConventionService(ConventionRepository conventionRepository) {
        this.conventionRepository = conventionRepository;
    }
    
    public ConventionResponse createConvention(ConventionRequest request,Long userId) {
    	User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    	
    	 String applicationCode = request.getApplication();
        String structurecode = request.getStructure();
        
        Application application = applicationRepository.findByCode(applicationCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found"));

        Structure structure = Optional.ofNullable(structureRepository.findByCode(structurecode))
        	    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Structure not found"));
        
        BigDecimal nbr_reel = request.getNbr_reel();
        BigDecimal nbr_Min = request.getNbr_Min();
        BigDecimal nbr_Max = request.getNbr_Max();
        
        if (nbr_Min == null || nbr_Max == null || nbr_reel == null) {
            throw new IllegalArgumentException("Nbr_Min, Nbr_Max, and Nbr_reel values cannot be null");
        }

        if (nbr_Min.compareTo(nbr_Max) > 0) {
            throw new IllegalArgumentException("Nbr_Min cannot be greater than Nbr_Max");
        }

        if (nbr_reel.compareTo(nbr_Min) < 0 || nbr_reel.compareTo(nbr_Max) > 0) {
            throw new IllegalArgumentException("Nbr_reel value must be between Nbr_Min and Nbr_Max");
        }
        
        /*if (nbr_reel == null) {
            throw new IllegalArgumentException(" value cannot be null");
        }

        if (nbr_Min.compareTo(BigDecimal.valueOf(15)) < 0) {
            throw new IllegalArgumentException("Minimum value cannot be less than 15: " + nbr_Min);
        }

        if (nbr_Max.compareTo(BigDecimal.valueOf(30)) > 0) {
            throw new IllegalArgumentException("Maximum value cannot be greater than 30: " + nbr_Max);
        }
        if (nbr_reel.compareTo(nbr_Min) < 0 || nbr_reel.compareTo(nbr_Max) > 0) {
            throw new IllegalArgumentException("Nbr_reel value must be between nbr_Min and nbr_Max");
        }*/
        
        Convention convention = new Convention();
        convention.setApplication(application);
        convention.setStructure(structure);
        convention.setUser(user);
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
        	    user.getEmail(),
        	    request.getNbr_reel(),
        	    convention.getTotalAmount(),
        	    convention.getNbr_Min(),
        	    convention.getNbr_Max(),
        	    convention.getDateSignature(),
        	    dueDate 
        	); 
        
        	return response;
    }
   /* private Long getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String username = userDetails.getUsername();
        
        // Retrieve the user from the database using the username
        User user = userRepository.findByUsername(username)
        		.orElseThrow(() -> new UsernameNotFoundException(username));
        
        return user.getId();
    }*/
}
