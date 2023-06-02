package com.spring.project.spring.controller;


import com.spring.project.spring.dto.TypeAchatDto;
import com.spring.project.spring.entities.TypeAchat;
import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.services.impl.TypeAchatServiceImpli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("typeAchat")
public class TypeAchatController {
@Autowired
    TypeAchatServiceImpli TypaAchatServ;
    @PostMapping(value = "/new")
    public TypeAchat addTypeAchat(@RequestBody TypeAchatDto typeAchatDto)
    {
        return TypaAchatServ.addTypeAchat(typeAchatDto);
    }
    @PostMapping(value = "update/{idTypeA}")
    public TypeAchat updateTypeAchat(@RequestBody TypeAchatDto typeAchatDto,
                               @PathVariable("idTypeA") int idTypeAchat) throws ResourceNotFoundException {

        return TypaAchatServ.updateTypeAchat(typeAchatDto, idTypeAchat);
    }
    @PostMapping(value = "delete/{idTypeAC}")
    public void deleteTypeAchat(@PathVariable("idTypeAC") int idTypeAchat) {
        TypaAchatServ.deleteTypeAchat(idTypeAchat);
    }


    @GetMapping(value = "/{IdTypeAchat}")
    public TypeAchatDto getTypeAchatById(@PathVariable("IdTypeAchat")int idTypeAchat){
        return TypaAchatServ.findTypeAchatById(idTypeAchat);
    }
    @GetMapping(value = "/getAll")
    public List<TypeAchatDto>getTypeAchat(){
        return TypaAchatServ.getAll();}
    }
