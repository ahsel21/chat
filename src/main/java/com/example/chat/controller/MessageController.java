package com.example.chat.controller;

import com.example.chat.dto.MessageDTO;
import com.example.chat.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @MessageMapping(value = "/messages")
    @SendTo("/topic/public")
    public MessageDTO sendMessage(@Valid MessageDTO messageDTO, @AuthenticationPrincipal Authentication authentication) {
        return messageService.save(messageDTO, authentication.getName());
    }

}
