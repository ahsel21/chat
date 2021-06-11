package com.example.chat.service.impl;


import com.example.chat.domain.Roles;
import com.example.chat.domain.Users;
import com.example.chat.repo.RolesRepository;
import com.example.chat.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {



    private RolesRepository rolesRepository;

    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public Roles addRoles(Roles roles) {
        return  rolesRepository.save(roles);
    }

    @Override
    public void delete(Integer id) {
        rolesRepository.deleteById(id);

    }

    @Override
    public Roles findByName(String name) {
        return  rolesRepository.findByName(name);
    }

    @Override
    public Roles editRoles(Roles roles) {
        return  rolesRepository.save(roles);
    }

    @Override
    public Set<Roles> findByUsers(Users user) {
        return rolesRepository.findByUsers(user);
    }

    @Override
    public List<Roles> findAll() {
        return rolesRepository.findAll();
    }
}
