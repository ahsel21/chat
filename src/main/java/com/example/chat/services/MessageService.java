package com.example.chat.services;

import com.example.chat.model.Message;
import java.util.List;


public interface MessageService {

    Message save(Message message);

    List<Message> findAll();

}