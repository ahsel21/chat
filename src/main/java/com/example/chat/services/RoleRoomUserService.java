package com.example.chat.services;

import com.example.chat.dto.RoleRoomUserDTO;
import com.example.chat.model.RoleRoomUser;
import com.example.chat.model.Room;
import com.example.chat.model.RoomRole;
import com.example.chat.model.User;

import java.util.List;

public interface RoleRoomUserService {

    List<RoleRoomUser> findByUser(User user);

    RoleRoomUserDTO save(RoleRoomUser roleRoomUser);

    List<RoleRoomUserDTO> findAllByUserAndRole(User user, RoomRole role);

    List<RoleRoomUserDTO> findAllByUserAndRoom(User user, Room room);

}
