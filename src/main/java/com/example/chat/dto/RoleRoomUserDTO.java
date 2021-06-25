package com.example.chat.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRoomUserDTO {


    private Long id;

    private RoomRoleDTO role;

    private RoomDTO room;

    private UserDTO user;

}
