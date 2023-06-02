package com.spring.project.spring.services.impl;


import com.spring.project.spring.dto.TypeAchatDto;

import com.spring.project.spring.entities.TypeAchat;
import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.repository.TypeAchatRepository;

import com.spring.project.spring.services.TypeAchatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeAchatServiceImpli implements TypeAchatService {
    @Autowired
    TypeAchatRepository typeAchatRep;
    Logger logger = LoggerFactory.getLogger(TypeAchatServiceImpli.class);

    @Override
    public TypeAchat addTypeAchat(TypeAchatDto typeAchatDto) {
        // TODO Auto-generated method stub
        typeAchatRep.save(TypeAchatDto.toEntity(typeAchatDto));

        return null;

    }

    @Override
    public TypeAchat updateTypeAchat(TypeAchatDto typeAchatDto, int idTypeAchatDto) throws ResourceNotFoundException {
        // TODO Auto-generated method stub

        TypeAchat TypeA = typeAchatRep.findById(idTypeAchatDto).orElseThrow(() -> new ResourceNotFoundException("not found"));
        logger.warn("achatType :" + TypeA.getAchatType());

        if (TypeA != null) {
            TypeA.setAchatType(typeAchatDto.getAchatType());
            return typeAchatRep.save(TypeA);
        }
        return TypeA;
    }

    @Override
    public TypeAchat deleteTypeAchat(int idTypeAchat) {
        // TODO Auto-generated method stub
        typeAchatRep.deleteById(idTypeAchat);
        return null;
    }

    @Override
    public TypeAchatDto findTypeAchatById(int idTypeAchat) {
        	// TODO Auto-generated method stub
        return TypeAchatDto.fromEntity(typeAchatRep.findById(idTypeAchat).get());
    }

    @Override
    public List<TypeAchatDto> getAll() {
        return typeAchatRep.findAll().stream().map(TypeAchatDto::fromEntity).collect(Collectors.toList());
    }
}
