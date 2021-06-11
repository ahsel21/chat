package com.example.chat.service.impl;

import com.example.chat.domain.Messages;
import com.example.chat.repo.MessagesRepository;
import com.example.chat.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessagesServiceImpl implements MessagesService {

    private MessagesRepository messagesRepository;

    @Autowired
    public MessagesServiceImpl(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    @Override
    public void save(Messages messages) {
        messagesRepository.save(messages);
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
    public List<Messages> findAll() {
        return messagesRepository.findAll();
    }

    @Override
    public Optional<Messages> findById(Integer id) {
        return messagesRepository.findById(id);
    }

    @Override
    public List<Messages> findAllByRoom_id(Integer room_id) {
        return messagesRepository.findAllByRoom_id(room_id);
    }

}
