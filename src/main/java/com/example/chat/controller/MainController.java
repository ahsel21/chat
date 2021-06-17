package com.example.chat.controller;

import com.example.chat.constaints.RoleConstant;
import com.example.chat.domain.Rooms;
import com.example.chat.domain.Users;
import com.example.chat.service.RoomsService;
import com.example.chat.service.UserService;
import com.example.chat.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZoneId;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private final UserDetailsServiceImpl userDetailsService;

    RoomsService roomsService;
    UserService userService;

    public MainController(UserDetailsServiceImpl userDetailsService, RoomsService roomsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.roomsService = roomsService;
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView getMessages(ZoneId zoneId, @AuthenticationPrincipal Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        List<Rooms> rooms = roomsService.findAllByUsernameAndRoleName(authentication.getName(), RoleConstant.ROLE_USER);
        modelAndView.addObject("rooms", rooms);
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("zonedid", zoneId);
        modelAndView.setViewName("index");

        return modelAndView;
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
