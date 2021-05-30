package com.example.chat.service.impl;

import com.example.chat.domain.Rooms;
import com.example.chat.repo.MessagesRepository;
import com.example.chat.repo.RoomsRepository;
import com.example.chat.service.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl implements RoomsService {

    private RoomsRepository roomsRepository;

    @Autowired
    public RoomsServiceImpl(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    @Override
    public Rooms addRoom(Rooms room) {
        return roomsRepository.save(room);
    }

    @Override
    public void delete(Integer id) {
        roomsRepository.deleteById(id);
    }

    @Override
    public Rooms getByName(String name) {
        return roomsRepository.findByName(name);
    }

    @Override
    public Rooms editRoom(Rooms room) {
        return roomsRepository.save(room);
    }

    @Override
    public List<Rooms> findAll() {
        return roomsRepository.findAll();
    }
}
