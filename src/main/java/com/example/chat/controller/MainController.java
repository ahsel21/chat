package com.example.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @GetMapping("/r")
    public String main() {
        return  "index";
    }

//    @GetMapping("/view/{name}")
//    public String view(@PathVariable("name") String name, Model model) {
//        model.addAttribute("msg", "Hello " + name + "!");
//        return "/index";
//    }
}
