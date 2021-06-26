package com.example.chat.controller;

import com.example.chat.dto.RoomDTO;
import com.example.chat.model.Room;
import com.example.chat.services.RoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RoomController {


    private final RoomService roomService;

    private final ModelMapper modelMapper;

    @MessageMapping(value = "/rooms/create")
    @SendTo("/topic/public")
    public void createRoom(@Valid RoomDTO roomDTO, @AuthenticationPrincipal Authentication authentication) {
        roomService.save(modelMapper.map(roomDTO, Room.class), authentication.getName());
    }

    @MessageMapping(value = "/rooms/remove")
    @SendTo("/topic/public")
    public void removeRoom(@Valid RoomDTO roomDTO, @AuthenticationPrincipal Authentication authentication) {
        roomService.delete(roomDTO.getName(), authentication.getName());
    }

    @PutMapping("/rooms/rename")
    public ModelAndView renameRoom() {
        return null;
    }

    @PostMapping("/rooms/{id}/users/{username}")
    public ModelAndView addUserInRoom() {
        return null;
    }

    @DeleteMapping("/rooms/{id}/users/{username}")
    public ModelAndView removeUserFromRoom() {
        return null;
    }

    @PutMapping("/rooms/{id}/users/{username}")
    public void muteUserInRoom() {

    }


}
