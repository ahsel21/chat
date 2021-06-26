package com.example.chat.services;

import com.example.chat.dto.MessageDTO;

import java.util.List;

public interface MessageService {

    MessageDTO save(MessageDTO messageDTO, String username);

    List<MessageDTO> findAll();

}
