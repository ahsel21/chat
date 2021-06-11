package com.example.chat.service.impl;

import com.example.chat.domain.Rooms;
import com.example.chat.repo.RoomsRepository;
import com.example.chat.service.RoomsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomsServiceImpl implements RoomsService {

    private RoomsRepository roomsRepository;

    @Autowired
    public RoomsServiceImpl(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    @Override
    public void save(Rooms room) {
        roomsRepository.save(room);
    }

    @Override
    public void deleteById(Integer id) {
        roomsRepository.deleteById(id);
    }

    @Override
    public Optional<Rooms> findById(Integer id) {
        return roomsRepository.findById(id);
    }

    @Override
    public Rooms findByName(String name) {
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

    @Override
    public List<Rooms> getRoomsByOwnerId(Integer owner_id){
        return roomsRepository.getRoomsByOwnerId(owner_id);
    }

}
