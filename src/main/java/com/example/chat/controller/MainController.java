package com.example.chat.controller;

import com.example.chat.domain.Users;
import com.example.chat.service.UserService;
import com.example.chat.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String main(Model model) {
        return "login";
    }


    @GetMapping("/registration")
    public String createUserForm(Users users){
        return "registration";
    }

    @PostMapping("/registration")
    public String create(Users users) {
        System.out.println(0);

        userDetailsService.save(users);

        System.out.println(1);
        return "redirect:/login";
    }

}
