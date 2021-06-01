package com.example.chat.service;

import com.example.chat.domain.Roles;
import com.example.chat.domain.Users;

import java.util.List;
import java.util.Set;

public interface RolesService {
    Roles addRoles(Roles roles);
    void delete(Integer id);
    Roles findByName(String name);
    Roles editRoles(Roles roles);
    Set<Roles> findByUsers(Users user);
    List<Roles> findAll();
}
