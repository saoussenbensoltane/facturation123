package com.spring.project.spring.controller;

import com.spring.project.spring.dto.DirectionAchatDto;


import com.spring.project.spring.entities.DirectionAchat;

import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.services.impl.DirectionAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("directionAchat")

public class DirectionAchatController {
    @Autowired
    DirectionAchatService directionAchatServ;
    @PostMapping(value = "/new")
    public DirectionAchat addDirectionAchat(@RequestBody DirectionAchatDto directionAchatDto) {
        return (DirectionAchat) directionAchatServ.addDirectionAchat(directionAchatDto);
    }
    @PostMapping(value="update/{idDirectionA}")

    public DirectionAchat updateDirectionAchat(@RequestBody DirectionAchatDto directionAchatDto ,
                                       @PathVariable("idDirectionA")int idDirectionA) throws ResourceNotFoundException
    {
        return directionAchatServ.updateDirectionAchat( directionAchatDto ,idDirectionA);
    }

    @PostMapping(value = "delete/{idDirec}")
    public void DeleteDirectionAchat(@PathVariable("idDirec") int idDirectionA) {
        directionAchatServ.DeleteDirectionAchat(idDirectionA);
    }
    @GetMapping(value = "/{idDirectionAch}")
    public DirectionAchatDto getDirectionById(@PathVariable("idDirectionAch")int idDirectionA){
        return directionAchatServ.findDirectionAchatById(idDirectionA);}

    @GetMapping(value = "/getAll")
    public List<DirectionAchatDto>getDirectionById(){
        return directionAchatServ.getAll();

    }
}
