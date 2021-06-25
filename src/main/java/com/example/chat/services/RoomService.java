package com.example.chat.services;

import com.example.chat.dto.RoomDTO;
import com.example.chat.model.Room;

import java.util.List;


public interface RoomService {

    List<RoomDTO> findAll();

    RoomDTO findById(Long id);

    RoomDTO save(Room room, String username);

    void delete(String roomName, String username);

    List<RoomDTO> findAllByUsernameAndRoleName(String username, String roomRoleName);

    List<RoomDTO> findAllByAdminUsernameAndRoomName(String username, String roomName);

}
