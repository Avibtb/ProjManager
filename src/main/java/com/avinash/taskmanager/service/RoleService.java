package com.avinash.taskmanager.service;

import org.springframework.beans.PropertyValues;

import com.avinash.taskmanager.model.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);

    List<Role> findAll();
}
