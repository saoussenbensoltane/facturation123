package com.spring.project.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.project.spring.dto.UtilisateurDto;
import com.spring.project.spring.entities.Utilisateur;
import com.spring.project.spring.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.project.spring.services.OrdonnateurService;

import java.util.List;

@RestController
@RequestMapping("/ordonnateur")
@CrossOrigin(origins = "http://localhost:4200/")

public class OrdonnateurController {
    @Autowired
    OrdonnateurService ordonnateurServ;

    @PostMapping(value = "/new")
    public Utilisateur addordonnateur(@RequestParam("utilisateur") String utilisateur, @RequestParam("role") String role) throws JsonProcessingException {
        System.out.println(role+".....");

        return ordonnateurServ.addordonnateur(utilisateur, role);
    }


    @PostMapping(value = "/update/{idordo}")
    public Utilisateur updateordonnateur(@RequestBody UtilisateurDto utilisateurDto,
                                         @PathVariable("idordo") int idordonnateur) throws ResourceNotFoundException {
        return ordonnateurServ.updateordonnateur(utilisateurDto, idordonnateur);
    }

    @PostMapping(value = "/{ido}")
    public void deleteordonnateur(@PathVariable("ido") int idordonnateur) {
        ordonnateurServ.deleteordonnateur(idordonnateur);
    }
@GetMapping(value = "getById/{IdOrdon}")
    public UtilisateurDto getOrdonnateurById(@PathVariable("IdOrdon")int idOrdon){
        return ordonnateurServ.findOrdonnateurById(idOrdon);
}

    @GetMapping(value ="/getAll" )
    public List<UtilisateurDto>getOrdonnateur(){
        return ordonnateurServ.getAll();
    }
}


