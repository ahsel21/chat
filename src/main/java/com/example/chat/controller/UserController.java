package com.example.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PutMapping("/users/{username}/rename")
    public ModelAndView renameUser() {
        return null;
    }

    @PutMapping("/users/{username}/ban")
    public void banUser() {
    }

    @PostMapping("/users/{username}/moder")
    public void addModerUser() {
    }

    @DeleteMapping("/users/{username}/unmoder")
    public void removeModerUser() {
    }

}
