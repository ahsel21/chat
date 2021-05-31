package com.example.chat.service;

import com.example.chat.domain.Rooms;
import com.example.chat.domain.Users;

import java.util.List;
import java.util.Optional;

public interface RoomsService {
    void save(Rooms rooms);
    void deleteById(Integer id);
    Optional<Rooms> findById(Integer id);
    Rooms findByName(String name);
    Rooms editRoom(Rooms rooms);
    List<Rooms> findAll();





}
