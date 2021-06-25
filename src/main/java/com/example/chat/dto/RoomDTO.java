package com.example.chat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoomDTO {

    private Long id;

    private String name;

    private boolean privateRoom;

    private boolean botRoom;

    private boolean deleted;

    private List<MessageDTO> messages;

}
