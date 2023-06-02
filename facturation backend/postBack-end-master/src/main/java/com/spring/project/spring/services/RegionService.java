package com.spring.project.spring.services;

import com.spring.project.spring.dto.RegionDto;
import com.spring.project.spring.entities.Region;
import com.spring.project.spring.exception.ResourceNotFoundException;

import java.util.List;


public interface RegionService {
Region addRegion(RegionDto regionDto);
 Region updateRegion(RegionDto regionDto,int idregionDto)throws ResourceNotFoundException;
Region deleteregion(int idregion );

    RegionDto findRegionById(int idRrgion);
    List<RegionDto>getAll();
}



