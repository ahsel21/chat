package com.example.chat.controller;

import com.example.chat.dto.RoomDTO;
import com.example.chat.constants.RoleConstant;
import com.example.chat.model.User;
import com.example.chat.services.RoomService;
import com.example.chat.services.UserService;
import com.example.chat.services.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.ZoneId;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private UserDetailsServiceImpl userDetailsService;

    private final RoomService roomService;

    private final UserService userService;

    @GetMapping("/")
    public ModelAndView getMessages(ZoneId zoneId, @AuthenticationPrincipal Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        List<RoomDTO> rooms = roomService.findAllByUsernameAndRoleName(authentication.getName(), RoleConstant.ROLE_USER);
        modelAndView.addObject("rooms", rooms);
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("zonedid", zoneId);
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @GetMapping("/registration")
    public String createUserForm(User user){
        return "registration";
    }

    @PostMapping("/registration")
    public String create(User user) {
        userDetailsService.save(user);
        return "redirect:/login";
    }

}
