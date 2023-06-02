package com.spring.project.spring.services.impl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.project.spring.dto.UtilisateurDto;
import com.spring.project.spring.entities.Role;
import com.spring.project.spring.entities.Utilisateur;
import com.spring.project.spring.exception.ResourceNotFoundException;
import com.spring.project.spring.model.UserRoleObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.spring.project.spring.repository.OrdonnateurRepository;
import com.spring.project.spring.services.OrdonnateurService;

import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdonnateurServiceImpl implements OrdonnateurService {
    OrdonnateurRepository ordonnateurRep;
    RoleServiceImpl roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    Logger logger = LoggerFactory.getLogger(OrdonnateurServiceImpl.class);

    @Autowired
    public OrdonnateurServiceImpl(OrdonnateurRepository ordonnateurRep, RoleServiceImpl roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.ordonnateurRep = ordonnateurRep;
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Utilisateur addordonnateur(String utilisateur, String role) throws JsonProcessingException {
        System.out.println(role);
        Utilisateur user = new ObjectMapper().readValue(utilisateur,Utilisateur.class);
        Role role1 = new ObjectMapper().readValue(role, Role.class);

        // TODO Auto-generated method stub
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        UserRoleObject userRoleObject = new UserRoleObject();
        userRoleObject.setMatricule(user.getMatricule());
        userRoleObject.setRoleName(role1.getRoleName());
        System.out.println(userRoleObject+"!!!!!!!!!");
        ordonnateurRep.save(user);
        this.roleService.addRoleToUser(userRoleObject);
        return null;
    }

    @Override
    public Utilisateur updateordonnateur(UtilisateurDto utilisateurDto, int idordonnateurDto) throws ResourceNotFoundException {
        // TODO Auto-generated method stub

        Utilisateur ordo = ordonnateurRep.findById(idordonnateurDto).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        logger.warn("matricule : " + ordo.getMatricule());
        if (ordo != null) {
            ordo.setMatricule(utilisateurDto.getMatricule());
            ordo.setEmail(utilisateurDto.getEmail());
            ordo.setNom((utilisateurDto.getNom()));
            ordo.setPrenom(utilisateurDto.getPrenom());
            ordo.setPassword(utilisateurDto.getPassword());
            ordo.setPassword(utilisateurDto.getPassword());
            return ordonnateurRep.save(ordo);
        }
        return ordo;
    }


    @Override
    public Utilisateur deleteordonnateur(int idordonnateur) {
        // TODO Auto-generated method stub
        ordonnateurRep.deleteById(idordonnateur);


        return null;

    }

    @Override
    public UtilisateurDto findOrdonnateurById(int idOrdonnateur) {
        // TODO Auto-generated method stub
        return UtilisateurDto.fromEntity(ordonnateurRep.findById(idOrdonnateur).get());
    }

    @Override
    public List<UtilisateurDto> getAll() {
        return ordonnateurRep.findAll().stream().map(UtilisateurDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Utilisateur getUserByMatricule(String matricule) {
        return this.ordonnateurRep.findUtilisateurByMatricule(matricule);
    }


}
