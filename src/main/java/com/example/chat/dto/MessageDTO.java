package com.example.chat.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class MessageDTO {

    private Long id;

    private UserDTO author;

    @JsonBackReference
    private RoomDTO room;

    private String messageText;

    private ZonedDateTime createdDateTime;

}
