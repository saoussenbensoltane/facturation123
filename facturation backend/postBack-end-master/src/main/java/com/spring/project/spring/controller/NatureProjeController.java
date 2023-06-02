package com.spring.project.spring.controller;


import com.spring.project.spring.dto.NatureProjetDto;

import com.spring.project.spring.entities.NatureProjet;

import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.services.impl.NatureProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("natureProjet")
public class NatureProjeController {
    @Autowired
    NatureProjetService NatureProjetServ;
    @PostMapping(value = "/")
    public NatureProjet addNatureProjet(@RequestBody NatureProjetDto natureProjetDto)
    {
        System.out.println(natureProjetDto.getNature());
        return NatureProjetServ.addNatureProjet(natureProjetDto);
    }
    @PostMapping(value = "/update/{idNatureP}")
    public  NatureProjet updateTypeNatureProjet(@RequestBody NatureProjetDto natureProjetDto,
                                     @PathVariable("idNatureP") int idNatureProjet) throws ResourceNotFoundException {

        return NatureProjetServ.updateTypeNatureProjet(natureProjetDto, idNatureProjet);
    }

    @PostMapping(value = "delete/{idNature}")
    public void  deleteNatureProjet(@PathVariable("idNature") int idNatureProjet) {
      NatureProjetServ.deleteNatureProjet(idNatureProjet);
    }


@GetMapping(value = "/{IdNatureProjet}")
    public NatureProjetDto getNatureProjetById(@PathVariable("IdNatureProjet")int idNatureProjet){
        return NatureProjetServ.findNatureProjetById(idNatureProjet);
}
@GetMapping(value = "/getAll")
    public List<NatureProjetDto>getNatureProjet(){
        return NatureProjetServ.getAll();}
}
