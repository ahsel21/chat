package com.example.chat.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageDTO {

    private Long id;

    private String messageText;

    private String author;

    private LocalDateTime createdDateTime;

    public MessageDTO() {
    }

}
