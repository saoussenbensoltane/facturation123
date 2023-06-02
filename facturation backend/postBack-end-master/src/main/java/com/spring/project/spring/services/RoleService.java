package com.spring.project.spring.services;

import com.spring.project.spring.entities.Role;
import com.spring.project.spring.model.UserRoleObject;

import java.util.List;

public interface RoleService {
    Role addNewRole(Role role);
    List<Role> getAllRoles();
    void addRoleToUser(UserRoleObject userRoleObject);
}
