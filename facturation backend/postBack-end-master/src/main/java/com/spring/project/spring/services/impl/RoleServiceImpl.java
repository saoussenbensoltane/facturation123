package com.spring.project.spring.services.impl;

import com.spring.project.spring.entities.Role;
import com.spring.project.spring.entities.Utilisateur;
import com.spring.project.spring.model.UserRoleObject;
import com.spring.project.spring.repository.OrdonnateurRepository;
import com.spring.project.spring.repository.RoleRepository;
import com.spring.project.spring.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private OrdonnateurRepository ordonnateurRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, OrdonnateurRepository ordonnateurRepository) {
        this.roleRepository = roleRepository;
        this.ordonnateurRepository = ordonnateurRepository;
    }



    @Override
    public Role addNewRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }

    @Override
    @Transactional
    public void addRoleToUser(UserRoleObject userRoleObject) {
        Utilisateur user = this.ordonnateurRepository.findUtilisateurByMatricule(userRoleObject.getMatricule());
        Role role = this.roleRepository.findRoleByRoleName(userRoleObject.getRoleName());
        user.getRoles().add(role);
    }
}
