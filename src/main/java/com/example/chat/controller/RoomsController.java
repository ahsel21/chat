package com.example.chat.controller;

import com.example.chat.domain.Rooms;
import com.example.chat.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class RoomsController {

    private final RoomsService roomsService;

    @Autowired
    public RoomsController(RoomsService roomsService) {
        this.roomsService = roomsService;
    }

    @GetMapping("/rooms")
    public String main(Model model) {
        List<Rooms> rooms = roomsService.findAll();
        model.addAttribute("rooms", rooms);
        return "rooms-list";
    }

}
