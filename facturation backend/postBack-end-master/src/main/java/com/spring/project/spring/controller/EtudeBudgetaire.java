package com.spring.project.spring.controller;

import com.spring.project.spring.dto.EtudeBudgetaireDto;
import com.spring.project.spring.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.project.spring.services.EtudeBudgetaireService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
@RestController
@RequestMapping("budget")
public class EtudeBudgetaire {
@Autowired
EtudeBudgetaireService budgetServ;
    @PostMapping(value ="/")
		public com.spring.project.spring.entities.EtudeBudgetaire addbudget(@RequestBody EtudeBudgetaireDto etudeBudgetaireDto) {
    return budgetServ.addBudget(etudeBudgetaireDto);
}
	@PostMapping(value = "update/{idbud}")
	public void updatebudget(@RequestBody EtudeBudgetaireDto etudeBudgetaireDto, @PathVariable("idbud") int idbudget) throws ResourceNotFoundException {

		budgetServ.updatebudget(etudeBudgetaireDto, idbudget);
	}
	@PostMapping(value = "delete/{idb}")
	public void deletebudget(@PathVariable("idb") int idbudget) {
		budgetServ.deletebudget(idbudget);
	}

	@GetMapping(value = "/getById/{IdBudget}")
	public EtudeBudgetaireDto getBudgetById(@PathVariable("IdBudget") int idbudget){
		return  budgetServ.findBudgetById(idbudget);
	}

	@GetMapping(value = "/getAll")
	public List<EtudeBudgetaireDto> getBudgetById(){
		return  budgetServ.getAll();
	}
}



