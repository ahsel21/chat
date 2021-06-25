package com.example.chat.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String username;

    @JsonBackReference
    private String password;

    private List<RoomRoleDTO> roomRoles;

}
