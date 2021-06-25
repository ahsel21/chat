package com.example.chat.controllers;

import com.example.chat.dto.MessageDTO;
import com.example.chat.model.Message;
import com.example.chat.services.MessageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/")
    public ModelAndView getMessages() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("messages", messageService.findAll());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping(value = "/messages")
    public ModelAndView sendMessage(@ModelAttribute("message") MessageDTO messageDTO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Message message = convertToEntity(messageDTO);
        messageService.save(message);
        return modelAndView;
    }


    private Message convertToEntity(MessageDTO messageDTO){
        Message message = modelMapper.map(messageDTO, Message.class);
        return message;
    }



}
