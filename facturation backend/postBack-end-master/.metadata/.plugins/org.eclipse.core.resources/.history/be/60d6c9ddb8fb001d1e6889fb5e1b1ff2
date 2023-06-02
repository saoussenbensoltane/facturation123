package com.app.security.services;

import com.app.models.ERole;
import com.app.models.Role;
import com.app.models.User;
import com.app.repository.RoleRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles(){
        return this.roleRepository.findAll();
    }

    @Transactional
    public void addRoleToUser(ERole role, int id){
        User user = this.userRepository.findById(id).get();
        Role role1 = this.roleRepository.findByName(role).get();
        user.getRoles().add(role1);

    }
}