package com.example.chat.controller;

import com.example.chat.domain.Roles;
import com.example.chat.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RolesController {

    private final RolesService rolesService;
    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/roles")
    public String main(Model model) {
        List<Roles> roles = rolesService.findAll();
        model.addAttribute("roles", roles);
        return "roles-list";
    }

}
