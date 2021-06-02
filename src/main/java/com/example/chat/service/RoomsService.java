package com.example.chat.service;

import com.example.chat.domain.Rooms;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoomsService {
    void save(Rooms rooms);
    void deleteById(Integer id);
    Rooms findByName(String name);
    Rooms editRoom(Rooms rooms);
    List<Rooms> findAll();


    Optional<Rooms> findById(Integer id);
}
