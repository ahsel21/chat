package com.example.chat.controller;

import com.example.chat.domain.Messages;
import com.example.chat.domain.Roles;
import com.example.chat.domain.Users;
import com.example.chat.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MessagesController {

    private final MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping("/messages")
    public String main(Model model) {
        List<Messages> messages = messagesService.getAll();
        model.addAttribute("message", messages);
        return "messages-list";
    }
}
