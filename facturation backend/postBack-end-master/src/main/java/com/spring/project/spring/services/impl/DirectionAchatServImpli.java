package com.spring.project.spring.services.impl;

import com.spring.project.spring.dto.DirectionAchatDto;
import com.spring.project.spring.entities.DirectionAchat;
import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.repository.DirectionAchatReository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectionAchatServImpli implements DirectionAchatService {
    @Autowired
    DirectionAchatReository directionAchatRep;
    Logger logger = LoggerFactory.getLogger(DirectionAchatServImpli.class);

    @Override
    public DirectionAchat addDirectionAchat(DirectionAchatDto directionAchatDto) {
        directionAchatRep.save(DirectionAchatDto.toEntity(directionAchatDto));
    return null;
    }

    @Override
    public DirectionAchat updateDirectionAchat(DirectionAchatDto directionAchatDto, int iddirectionAchatDto) throws ResourceNotFoundException {
        // TODO Auto-generated method stub
        DirectionAchat Direc= directionAchatRep.findById(iddirectionAchatDto).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        logger.warn("achatDirection :"+ directionAchatDto.getAchatDirection());
        if ( Direc !=null){
            Direc.setAchatDirection(directionAchatDto.getAchatDirection());
            return directionAchatRep.save(Direc);
        }
        return Direc;
    }

    @Override
    public DirectionAchat DeleteDirectionAchat(int iddirectionAchat) {
        // TODO Auto-generated method stub
        directionAchatRep.deleteById(iddirectionAchat);
        return null;
    }

    @Override
    public DirectionAchatDto findDirectionAchatById(int iddirectionAchat) {
        // TODO Auto-generated method stub

        return DirectionAchatDto.fromEntity(directionAchatRep.findById(iddirectionAchat).get());
    }

    @Override
    public List<DirectionAchatDto> getAll() {
                return directionAchatRep.findAll().stream().map(DirectionAchatDto::fromEntity).collect(Collectors.toList());
    }


}
