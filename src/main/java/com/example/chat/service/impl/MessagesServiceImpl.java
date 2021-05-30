package com.example.chat.service.impl;

import com.example.chat.domain.Messages;
import com.example.chat.repo.MessagesRepository;
import com.example.chat.repo.RolesRepository;
import com.example.chat.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagesServiceImpl implements MessagesService {

    private MessagesRepository messagesRepository;

    @Autowired
    public MessagesServiceImpl(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    @Override
    public Messages addMessages(Messages messages) {
        return messagesRepository.save(messages);
    }

    @Override
    public void delete(Integer id) {
        messagesRepository.deleteById(id);
    }

    @Override
    public Messages editMessages(Messages messages) {
        return messagesRepository.save(messages);
    }

    @Override
    public List<Messages> getAll() {
        return messagesRepository.findAll();
    }
}
