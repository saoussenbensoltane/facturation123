package com.spring.project.spring.services;

import com.spring.project.spring.dto.TypeAchatDto;

import com.spring.project.spring.entities.TypeAchat;
import com.spring.project.spring.exception.ResourceNotFoundException;

import java.util.List;

public interface TypeAchatService {

     TypeAchat addTypeAchat(TypeAchatDto typeAchatDto);
     TypeAchat updateTypeAchat(TypeAchatDto typeAchatDto, int idtypeAchatDto)throws ResourceNotFoundException;
    TypeAchat deleteTypeAchat(int idTypeAchat);

    TypeAchatDto findTypeAchatById(int idTypeAchat);
    List<TypeAchatDto>getAll();
}
