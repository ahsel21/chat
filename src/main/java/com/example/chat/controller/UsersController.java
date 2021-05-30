package com.example.chat.controller;

import com.example.chat.domain.Users;
import com.example.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/users/create")
    public String createUserForm(Users users){
        return "user-create";
    }

    @PostMapping("/users/create")
    public String create(Users users) {
        userService.save(users);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteById(id);
        System.out.println(id);
        return "redirect:/users";
    }

    @GetMapping("/users/update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, Model model){
        Optional<Users> user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/users/update")
    public String updateUser(Users user){
        userService.save(user);
        return "redirect:/users";
    }


}
