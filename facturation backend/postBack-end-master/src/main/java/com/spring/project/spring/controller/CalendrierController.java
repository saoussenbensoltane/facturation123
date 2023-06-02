package com.spring.project.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.project.spring.dto.ProjetEnCoursDto;
import com.spring.project.spring.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.spring.project.spring.dto.CalendrierDto;
import com.spring.project.spring.entities.Calendrier;
import com.spring.project.spring.services.CalendrierService;
import com.spring.project.spring.services.impl.CalendrierServImpl;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calendrier")

public class CalendrierController {
	@Autowired
	CalendrierServImpl calendrierServ;
	
	@PostMapping(value="/")
	public Calendrier addcalendrier(@RequestParam("user") String ordonnateur,
									@RequestParam("calendrier") String projet,
									@RequestParam("region") String region,
									@RequestParam("natureProject") String natureProjet,
									@RequestParam("typeAchat") String typeAchat) throws JsonProcessingException {
		return calendrierServ.addcalendrier(ordonnateur, projet, region, natureProjet, typeAchat);
}
	@PostMapping(value="/{id0}")

	public CalendrierDto updatecalendrierSelection(@RequestBody CalendrierDto calendrierDto ,
									   @PathVariable("id0")int idcalendrier) throws ResourceNotFoundException
	{
		return calendrierServ.updatecalendrier(calendrierDto ,idcalendrier );
	}
	@PostMapping(value="/delete/{idCalendrier}")
	public void deletecalendrier(@PathVariable("idCalendrier")int idCalendrierDto)
	{
		System.out.println(idCalendrierDto+"§§§§§§");
		 calendrierServ.deletecalendrier(idCalendrierDto);
	}
	@GetMapping(value ="/{IdCal}")
	public CalendrierDto getCalendrierById(@PathVariable("IdCal")int idcalendrier){
		return calendrierServ.findCalendrierById(idcalendrier);
	}
	@GetMapping(value = "/getAll")
	public List<CalendrierDto>getCalendrierById(){
		return calendrierServ.getAll();}

	@GetMapping("/unSelected/{selected}")
	public List<CalendrierDto> getUnSelectedProject(@PathVariable boolean selected){
		return this.calendrierServ.fetSelectedProject(selected).stream().map(CalendrierDto::fromEntity).collect(Collectors.toList());
	}

	@GetMapping("/selected/{selected}")
	public List<CalendrierDto> getSelectedProject(@PathVariable boolean selected){
		return this.calendrierServ.fetSelectedProject(selected).stream().map(CalendrierDto::fromEntity).collect(Collectors.toList());
	}

	@PostMapping("/select/{id0}")
	public void selectCalendrier(@RequestBody CalendrierDto calendrierDto ,
								   @PathVariable("id0")int idcalendrier) throws ResourceNotFoundException {
		this.calendrierServ.selectProject(calendrierDto, idcalendrier);
	}
}

