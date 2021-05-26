package com.example.chat.repo;

import com.example.chat.domain.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer> {
    List<Messages> findMessagesByAuthor(Integer user_id);
    List<Messages> findMessagesByRooms(Integer room_id);
    List<Messages> findAll();

    @Override
    void delete(Messages messages);
}
