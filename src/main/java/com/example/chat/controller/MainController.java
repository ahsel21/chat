package com.example.chat.controller;

import com.example.chat.domain.Messages;
import com.example.chat.domain.Users;
import com.example.chat.service.UserService;
import com.example.chat.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/")
    public String rooms() {
        return "redirect:/welcome";
    }

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
        userDetailsService.save(users);
        return "redirect:/login";
    }

    @GetMapping("/welcome")
    public String getMessagesByRoom(Model model) {
//        //todo убрать логику в слой сервисов!!!!

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("login", auth.getName());

        return "welcome";
    }

}
