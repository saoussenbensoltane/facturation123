package com.spring.project.spring.controller;

import com.spring.project.spring.entities.Role;
import com.spring.project.spring.model.UserRoleObject;
import com.spring.project.spring.services.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    private RoleServiceImpl roleService;

    @Autowired
    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/addRole")
    public Role addNewRole(@RequestBody Role role){
        return this.roleService.addNewRole(role);
    }

    @GetMapping("/allRoles")
    public List<Role> getAllRoles(){
        return this.roleService.getAllRoles();
    }

    @PostMapping("/addRoleToUser")
    public void addRoleToUser(@RequestBody UserRoleObject userRoleObject){
        this.roleService.addRoleToUser(userRoleObject);
    }
}
