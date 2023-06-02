package com.spring.project.spring.services.impl;

import com.spring.project.spring.dto.DirectionAchatDto;
import com.spring.project.spring.entities.DirectionAchat;
import com.spring.project.spring.exception.ResourceNotFoundException;

import java.util.List;

public interface DirectionAchatService {
     DirectionAchat addDirectionAchat(DirectionAchatDto directionAchatDto);
     DirectionAchat updateDirectionAchat(DirectionAchatDto directionAchatDto, int iddirectionAchatDto)
        throws ResourceNotFoundException;
     DirectionAchat DeleteDirectionAchat(int iddirectionAchat);
     DirectionAchatDto findDirectionAchatById(int iddirectionAchat);
     List<DirectionAchatDto>getAll();

}
