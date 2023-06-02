package com.spring.project.spring.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.spring.dto.NatureProjetDto;
import com.spring.project.spring.dto.RegionDto;
import com.spring.project.spring.dto.TypeAchatDto;
import com.spring.project.spring.entities.*;
import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.repository.NatureProjetRepository;
import com.spring.project.spring.repository.RegionRepository;
import com.spring.project.spring.repository.TypeAchatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.project.spring.dto.CalendrierDto;

import com.spring.project.spring.repository.CalendrierRepository;
import com.spring.project.spring.services.CalendrierService;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Service
public  class CalendrierServImpl implements CalendrierService {
@Autowired
CalendrierRepository calendrierRep;

	@Autowired
	NatureProjetServImpli natureProjetService;

	@Autowired
	NatureProjetRepository natureProjetRep;

	@Autowired
	OrdonnateurServiceImpl ordonnateurService;
	@Autowired
	RegionServiceImpli regionService;

	@Autowired
	TypeAchatRepository typeAchatRep;


	@Autowired
	TypeAchatServiceImpli typeAchatService;

	@Autowired
	RegionRepository regionRepository;

	@Autowired
	NatureProjetRepository natureProjetRepository;
	Logger logger = LoggerFactory.getLogger(CalendrierServImpl.class);
	@Override
	public Calendrier addcalendrier  (String ordonnateur, String projet, String reg, String natureProjet, String typeAchat) throws JsonProcessingException {
		Utilisateur user = new ObjectMapper().readValue(ordonnateur, Utilisateur.class);
		CalendrierDto calendrier = new ObjectMapper().readValue(projet, CalendrierDto.class);
		Region region = new ObjectMapper().readValue(reg, Region.class);
		NatureProjet n = new ObjectMapper().readValue(natureProjet, NatureProjet.class);
		NatureProjet natureProjet1 = this.natureProjetRep.findById(n.getId()).get();
		TypeAchat t = new ObjectMapper().readValue(typeAchat, TypeAchat.class);
		System.out.println(t.getId());

		TypeAchat typeAchat1 = this.typeAchatRep.findById(t.getId()).get();
		typeAchat1.getAchatType();
		Calendrier newProject = new Calendrier();

		newProject.setOrdo(user);
		newProject.setReg(region);
		newProject.setNatureProjets(natureProjet1);
		newProject.setTypeA(typeAchat1);
		newProject.setNumCompte(calendrier.getNumCompte());
		newProject.setCoutInitial(calendrier.getCoutInitial());
		newProject.setCoutMisAjour(calendrier.getCoutMisAjour());
		newProject.setNumCompte(calendrier.getNumCompte());
		newProject.setDateAgrementSpecifications(calendrier.getDateAgrementSpecifications());
		newProject.setDateNegociation(calendrier.getDateNegociation());
		newProject.setDateOuvertureSoumission(calendrier.getDateOuvertureSoumission());
		newProject.setResponsable(calendrier.getResponsable());
		newProject.setDateTransmissionComite(calendrier.getDateTransmissionComite());
		newProject.setSujet(calendrier.getSujet());
		newProject.setSelected(false);
		// TODO Auto-generated method stub
		calendrierRep.save(newProject);
		return null ;
	}
	@Override
	public CalendrierDto updatecalendrier(CalendrierDto calendrierDto, int idcalendrierDto) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Calendrier cal =calendrierRep.findById(idcalendrierDto).orElseThrow(()-> new ResourceNotFoundException ("Not found"));
		 logger.warn("Natureprojet: " + cal);
		      if (cal!= null) {
		          cal.setNumCompte(calendrierDto.getNumCompte());
				  cal.setSujet(calendrierDto.getSujet());
				  cal.setCoutInitial(calendrierDto.getCoutInitial());
				  cal.setCoutMisAjour(calendrierDto.getCoutMisAjour());
				  cal.setDateOuvertureSoumission(calendrierDto.getDateOuvertureSoumission());
				  cal.setDateReponseCommite(calendrierDto.getDateReponseCommite());
				  cal.setDateNegociation(calendrierDto.getDateNegociation());
				  cal.setDateTransmissionComite(calendrierDto.getDateTransmissionComite());
		          cal.setReg(this.regionRepository.getReferenceById(calendrierDto.getRegion()));
				  cal.setTypeA(this.typeAchatRep.getReferenceById(calendrierDto.getTypeA()));
				  cal.setNatureProjets(this.natureProjetRep.getReferenceById(calendrierDto.getNatureprojet()));
				  return CalendrierDto.fromEntity(calendrierRep.save(cal));
		      }
		return CalendrierDto.fromEntity(cal);
	}


	@Override
	public Calendrier deletecalendrier(int idCalendrierDto) {
		// TODO Auto-generated method stub
		calendrierRep.deleteById(idCalendrierDto);
		
		
		return null;
		
	}

	@Override
	public CalendrierDto findCalendrierById(int idcalendrier) {
		// TODO Auto-generated method stub
		return CalendrierDto.fromEntity(calendrierRep.findById(idcalendrier).get());


	}

	@Override
	public List<CalendrierDto> getAll() {
		return calendrierRep.findAll().stream().map(CalendrierDto::fromEntity).collect(Collectors.toList());
	}

	@Override
	public List<Calendrier> fetSelectedProject(boolean selected) {
		return this.calendrierRep.findCalendrierBySelected(selected);
	}

	@Override
	public String selectProject(CalendrierDto calendrierDto, int idCal) throws ResourceNotFoundException {
		Calendrier ibvdfvd =calendrierRep.findById(idCal).orElseThrow(()-> new ResourceNotFoundException ("Not found"));
		if (ibvdfvd != null){
			ibvdfvd.setSelected(calendrierDto.isSelected());
			ibvdfvd.setDateDebutProjet(calendrierDto.getDateDebutProjet());
			ibvdfvd.setDateAchevemetProjet(calendrierDto.getDateAchevemetProjet());
			ibvdfvd.setCouleur(calendrierDto.getCouleur());
			calendrierRep.save(ibvdfvd);
			return "Successfully updated!";
		}
		else return "null";
	}
}


