package com.example.chat.repo;

import com.example.chat.domain.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer> {
    List<Messages> findAllByUser_id(Integer user_id);
    List<Messages> findAllByRoom_id(Integer room_id);
    List<Messages> findAll();

    @Override
    void delete(Messages messages);
    Messages add(Messages messages);
    Messages update(Messages messages);
}
