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
        List<Messages> messages = messagesService.getAll();
        model.addAttribute("message", messages);
        return "messages-list";
    }
    @GetMapping("/messages/create")
    public String createUserForm(Messages messages){
        return "message-create";
    }

    @PostMapping("/message/create")
    public String create(Messages messages) {
        messagesService.addMessages(messages);
        return "redirect:/messages";
    }

    @GetMapping("/messages/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        messagesService.delete(id);
        System.out.println(id);
        return "redirect:/messages";
    }

    @GetMapping("/messages/update/{id}")
    public String updateMessageForm(@PathVariable("id") Integer id, Model model){
        Optional<Messages> messages = Optional.ofNullable(messagesService.findById(id));
        model.addAttribute("messages", messages);
        return "message-update";
    }

    @PostMapping("/messages/update")
    public String updateMessage(Messages message){
        messagesService.addMessages(message);
        return "redirect:/messages";
    }
}
