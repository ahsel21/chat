package com.example.chat.controller;

import com.example.chat.domain.Messages;
import com.example.chat.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MessagesController {
    private final MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping("/messages")
    public String main(Model model) {
        List<Messages> messages = messagesService.findAll();
        model.addAttribute("messages", messages);
        System.out.println(messages );
        return "messages-list";
    }
    @GetMapping("/messages/create")
    public String createUserForm(Messages messages){
        return "message-create";
    }

    @PostMapping("/messages/create")
    public String create(Messages messages) {
        messagesService.save(messages);
        return "redirect:/messages";
    }

    @GetMapping("/messages/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        messagesService.delete(id);
        return "redirect:/messages";
    }

    @GetMapping("/messages/update/{id}")
    public String updateMessageForm(@PathVariable("id") Integer id, Model model){
        Optional<Messages> messages = messagesService.findById(id);
        model.addAttribute("message", messages);
        return "message-update";
    }

    @PostMapping("/messages/update")
    public String updateMessage(Messages message){
        messagesService.save(message);
        return "redirect:/messages";
    }
}
