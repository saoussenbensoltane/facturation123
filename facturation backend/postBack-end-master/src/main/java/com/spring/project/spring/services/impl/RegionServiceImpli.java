package com.spring.project.spring.services.impl;

import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.services.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.project.spring.dto.RegionDto;
import com.spring.project.spring.entities.Region;
import com.spring.project.spring.repository.RegionRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RegionServiceImpli implements RegionService {
	@Autowired
	RegionRepository regionRep;
	Logger logger = LoggerFactory.getLogger(RegionServiceImpli.class);

	@Override
	public Region addRegion(RegionDto regionDto) {
		// TODO Auto-generated method stub
		regionRep.save(RegionDto.toEntity(regionDto));
		return null;
	}

	@Override
	public Region updateRegion(RegionDto regionDto, int idregionDto) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Region reg=regionRep.findById(idregionDto).orElseThrow(()->new ResourceNotFoundException("not found"));
		logger.warn("nomRegion:"+reg.getNomRegion());

     if (reg != null) {
			reg.setNomRegion(regionDto.getNomRegion());
			return regionRep.save(reg);
		}
		return reg;
}

	@Override
	public Region deleteregion(int idregion) {
		// TODO Auto-generated method stub
regionRep.deleteById(idregion);
		return null;
	}

	@Override
	public RegionDto findRegionById(int idRrgion) {
		// TODO Auto-generated method stub
		return RegionDto.fromEntity(regionRep.findById(idRrgion).get());
	}

	@Override
	public List<RegionDto> getAll() {
		return regionRep.findAll().stream().map(RegionDto::fromEntity).collect(Collectors.toList());
	}

}
