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


    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public Roles addRoles(Roles user) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Roles getByName(String name) {
        return null;
    }

    @Override
    public Roles editRoles(Roles room) {
        return null;
    }

    @Override
    public List<Roles> getAll() {
        return rolesRepository.findAll();
        //return null;
    }
}
