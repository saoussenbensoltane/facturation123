package com.spring.project.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.project.spring.dto.FichTechniqueDetailsDto;
import com.spring.project.spring.services.FicheTechniqueService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.dto.FicheTechniqueDto;
import com.spring.project.spring.entities.FicheTechnique;

import java.util.List;

@RestController
@RequestMapping("ficheTechnique")
public class FicheController {
	@Autowired
	FicheTechniqueService ficheServ;

	@PostMapping(value = "/{idCal}")
	public FicheTechnique addfiche(@RequestBody FicheTechniqueDto fiche, @PathVariable int idCal) throws JsonProcessingException {
		return ficheServ.addfiche(fiche, idCal);
	}

	@PostMapping(value = "update/{idfich}")
	public void updatefiche(@RequestBody FicheTechniqueDto ficheTechniqueDto, @PathVariable("idfich") Integer idfiche) throws ResourceNotFoundException {

		ficheServ.updatefiche(ficheTechniqueDto, idfiche);
	}

	@PostMapping(value = "delete/{idfi}")
	public void deletefiche(@PathVariable("idfi") Integer idfiche) {
		ficheServ.deletefiche(idfiche);
	}
	@GetMapping	(value = "/{IdFiche}")
	public FichTechniqueDetailsDto getFicheTechniqueById(@PathVariable("IdFiche")Integer idfiche){
		return ficheServ.findFicheTechniqueById(idfiche);
	}
	@GetMapping(value = "/getAll")
	public List<FicheTechniqueDto>getFicheTechniqueById(){
		return ficheServ.getAll();
	}
}