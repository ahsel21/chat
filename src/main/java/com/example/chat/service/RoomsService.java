package com.example.chat.service;

import com.example.chat.domain.Rooms;

import java.util.List;

public interface RoomsService {
    Rooms addRoom(Rooms user);
    void delete(Integer id);
    Rooms getByName(String name);
    Rooms editRoom(Rooms room);
    List<Rooms> getAll();
}
