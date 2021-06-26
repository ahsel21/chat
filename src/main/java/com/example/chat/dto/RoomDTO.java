package com.example.chat.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
public class RoomDTO {

    private Long id;

    @NotBlank(message = "Write the room name")
    private String name;

    private boolean privateRoom;

    private boolean botRoom;

    private boolean deleted;

    private List<MessageDTO> messages;

}
