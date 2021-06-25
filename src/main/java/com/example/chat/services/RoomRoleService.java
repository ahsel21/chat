package com.example.chat.services;

import com.example.chat.dto.RoomRoleDTO;

public interface RoomRoleService {

    RoomRoleDTO findByName(String  name);

}
