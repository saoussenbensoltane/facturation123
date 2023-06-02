package com.spring.project.spring.controller;

import com.spring.project.spring.dto.ProjetEnCoursDto;
import com.spring.project.spring.entities.ProjetEnCours;
import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.services.impl.ProjetEnCoursService;
import com.spring.project.spring.services.impl.ProjetEnCoursServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetEnCours")
public class ProjetEnCoursController {
    @Autowired
    ProjetEnCoursService ProjetEnCoursServ;
    @PostMapping(value = "/")
    public ProjetEnCours addProjetEnCours(@RequestBody ProjetEnCoursDto projetEnCoursDto){
        return ProjetEnCoursServ.addProjetEnCours(projetEnCoursDto);
    }
    @PutMapping(value = "/{idProjet}")
    public ProjetEnCours updateProjetEnCours(@RequestBody ProjetEnCoursDto projetEnCoursDto, @PathVariable("statusProjet")Long idProjet)throws ResourceNotFoundException{
        return ProjetEnCoursServ.updateProjetEnCours(projetEnCoursDto,idProjet);
    }

    @DeleteMapping(value = "/{idP}")
    public void deleteProjetEnCours(@PathVariable("statusP")Long idProjetEnCours){
        ProjetEnCoursServ.deleteProjetEnCours(idProjetEnCours);
    }

    @GetMapping(value = "/getAll")
    public List<ProjetEnCoursDto>getProjetEnCours(){
        return ProjetEnCoursServ.getAll();}

}

