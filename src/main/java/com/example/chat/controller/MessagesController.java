package com.example.chat.controller;

import com.example.chat.domain.Messages;
import com.example.chat.service.MessagesService;
import com.example.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    private final UserService userService;

    @Autowired
    public MessagesController(MessagesService messagesService, UserService userService) {
        this.messagesService = messagesService;
        this.userService = userService;
    }


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, Messages message) {
        System.out.println("handling send message: " + message + " to: " + to);
        boolean isExists = userService.findByLogin(to).getLogin().equals(to);
        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }

    @GetMapping("/messages")
    public String main(Model model) {
        //TODO всю логику вынести
        List<Messages> messages = messagesService.findAll();
        model.addAttribute("messages", messages);
        System.out.println(messagesService.findAllByRoom_id(36));
        return "messages-list";
    }
    @GetMapping("/messages/create")
    public String createUserForm(Messages messages){
        return "message-create";
    }

    @PostMapping("/messages/create")
    public String create(Messages messages) {
        messagesService.save(messages);
        return "redirect:/rooms";
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
