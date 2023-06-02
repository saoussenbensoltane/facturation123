package com.spring.project.spring.controller;

import com.spring.project.spring.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.project.spring.dto.RegionDto;
import com.spring.project.spring.entities.Region;
import com.spring.project.spring.services.impl.RegionServiceImpli;

import java.util.List;


@RestController
@RequestMapping("region")
public class RegionController {
	@Autowired
	RegionServiceImpli regionServ;
	@PostMapping(value="/new")
	public Region addRegion(@RequestBody RegionDto regionDto)
	{
		return regionServ.addRegion(regionDto);}
	@PostMapping(value = "/update/{idreg}")
	public Region updateregion(@RequestBody RegionDto regionDto,
							   @PathVariable("idreg") int idregion) throws ResourceNotFoundException {

		return regionServ.updateRegion(regionDto, idregion);
	}
	@PostMapping(value = "/delete/{idr}")
	public void deleteregion(@PathVariable("idr") int idregion) {
		regionServ.deleteregion(idregion);
	}

@GetMapping(value = "/{idRegion}")
	public RegionDto getRegionById(@PathVariable("idRegion")int idRegion){
	System.out.println(idRegion);
		return regionServ.findRegionById(idRegion);
}

	@GetMapping(value ="/getAll" )
  public List<RegionDto>getRegion(){
		return regionServ.getAll();}

}