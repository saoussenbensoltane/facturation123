package com.spring.project.spring.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.project.spring.dto.CalendrierDto;
import com.spring.project.spring.entities.Calendrier;
import com.spring.project.spring.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CalendrierService {
	
 Calendrier addcalendrier( String ordonnateur, String projet, String region, String natureProjet, String typeAchat) throws JsonProcessingException;
 CalendrierDto updatecalendrier(CalendrierDto calendrierDto,int idcalendrierDto)
       throws ResourceNotFoundException;
 Calendrier deletecalendrier(int idcalendrier );
 CalendrierDto findCalendrierById(int idcalendrier);
 List<CalendrierDto>getAll();

 List<Calendrier> fetSelectedProject(boolean selected);

 String selectProject(CalendrierDto calendrierDto, int idCal) throws ResourceNotFoundException;

}