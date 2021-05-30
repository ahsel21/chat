package com.example.chat.controller;

import com.example.chat.domain.Users;
import com.example.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersController {
    private final UserService userService;
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String main(Model model) {
        List<Users> users = userService.findAll();
        model.addAttribute("users", users);
        return "users-list";
    }
}
