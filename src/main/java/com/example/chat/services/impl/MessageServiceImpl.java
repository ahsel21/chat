package com.example.chat.services.impl;

import com.example.chat.model.Message;
import com.example.chat.repositories.MessageRepository;
import com.example.chat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Transactional
    public Message save(Message message) {
        message.setAuthor("TestAuthor");
        message.setCreatedDateTime(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @Transactional
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

}
