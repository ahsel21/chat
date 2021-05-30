package com.example.chat.service.impl;


import com.example.chat.domain.Roles;
import com.example.chat.repo.RolesRepository;
import com.example.chat.service.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public Roles getByName(String name) {
        return  rolesRepository.findByName(name);
    }

    @Override
    public Roles editRoles(Roles roles) {
        return  rolesRepository.save(roles);
    }

    @Override
    public List<Roles> findAll() {
        return rolesRepository.findAll();
    }
}
