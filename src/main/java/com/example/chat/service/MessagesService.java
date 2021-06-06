package com.example.chat.service;

import com.example.chat.domain.Messages;
import com.example.chat.domain.Users;

import java.util.List;
import java.util.Optional;

public interface MessagesService {
    void save(Messages message);
    void delete(Integer id);
    Messages editMessages(Messages messages);
    List<Messages> findAll();
    Optional<Messages> findById(Integer id);

}
