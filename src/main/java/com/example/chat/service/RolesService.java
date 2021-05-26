package com.example.chat.service;

import com.example.chat.domain.Roles;

import java.util.List;

public interface RolesService {
    Roles addRoles(Roles user);
    void delete(Integer id);
    Roles getByName(String name);
    Roles editRoles(Roles room);
    List<Roles> getAll();
}
