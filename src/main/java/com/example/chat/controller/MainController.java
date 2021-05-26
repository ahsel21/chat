package com.example.chat.controller;

import com.example.chat.domain.Roles;
import com.example.chat.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final RolesService rolesService;
    @Autowired
    public MainController(RolesService rolesService) {
        this.rolesService = rolesService;
    }


    @GetMapping("/r")
    public List<Roles> main() {
        return rolesService.getAll();
    }


}
