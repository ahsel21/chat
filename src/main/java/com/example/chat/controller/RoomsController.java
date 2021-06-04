package com.example.chat.controller;

import com.example.chat.domain.Messages;
import com.example.chat.domain.Rooms;
import com.example.chat.service.MessagesService;
import com.example.chat.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class RoomsController {

    private final MessagesService messagesService;
    private final RoomsService roomsService;

    @Autowired
    public RoomsController(MessagesService messagesService, RoomsService roomsService) {
        this.messagesService = messagesService;
        this.roomsService = roomsService;
    }

    @GetMapping("/rooms")
    public String getRooms(Model model) {
        List<Rooms> rooms = roomsService.findAll();
        model.addAttribute("rooms", rooms);
        return "rooms-list";
    }

    @GetMapping("/rooms/create")
    public String createRoomForm(Rooms room) {
        return "room-create";
    }

    @PostMapping("/rooms/create")
    public String create(Rooms room) {
        roomsService.save(room);
        return "redirect:/rooms";
    }

    @GetMapping("/rooms/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        roomsService.deleteById(id);
        return "redirect:/rooms";
    }

    @GetMapping("/rooms/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model) {
        Optional<Rooms> room = roomsService.findById(id);
        model.addAttribute("room", room);
        return "room-update";
    }

    @PostMapping("/rooms/update")
    public String updateUser(Rooms room) {
        roomsService.save(room);
        return "redirect:/rooms";
    }

    @GetMapping("/room/{room_id}")
    public String getMessagesByRoom(@PathVariable("room_id") Integer room_id, Model model) {
        List<Messages> messages = messagesService.findAll();
        messages.removeIf(mes -> mes.getRooms().getRoom_id() != room_id);
        model.addAttribute("messages", messages);
        model.addAttribute("room_id", room_id);
        System.out.println(room_id);
        return "message-in-room";
    }

    @PostMapping("/room/{room_id}")
    public String sendMessage(Messages messages) {
        messagesService.save(messages);
        return "redirect:/room/{room_id}";
    }

}
