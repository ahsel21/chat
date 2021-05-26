package com.example.chat.service;

import com.example.chat.domain.Messages;

import java.util.List;

public interface MessagesService {
    Messages addMessages(Messages messages);
    void delete(Integer id);
    Messages editMessages(Messages messages);
    List<Messages> getAll();
}
