package com.example.chat.controller;

import com.example.chat.domain.Roles;
import com.example.chat.service.RolesService;
import com.example.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class MainController {

//    private final RolesService rolesService;
//    @Autowired
//    public MainController(RolesService rolesService) {
//        this.rolesService = rolesService;
//    }
//
//    @GetMapping("/r")
//    public String main(Model model) {
//        List<Roles> roles = rolesService.findAll();
//        System.out.println(roles);
//        model.addAttribute("roless", roles);
//        return "roles";
//    }


}
