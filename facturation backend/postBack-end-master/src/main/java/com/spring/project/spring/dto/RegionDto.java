package com.spring.project.spring.dto;


import com.spring.project.spring.entities.Region;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionDto {
	private Integer id ;
	private String nomRegion;

	public static Region toEntity (RegionDto regionDto)
	{
		if(regionDto == null)
		{
			return null ;
		}
		Region region =new Region();
		region.setId(regionDto.getId()!=null? region.getId():null);
		region.setNomRegion(regionDto.getNomRegion());
		return region;

	}

	public static RegionDto fromEntity (Region region)
	{
		if(region == null)
		{
			return null ;
		}
		return RegionDto.builder()
				.id(region.getId())
				.nomRegion(region.getNomRegion())
				.build();}
}
