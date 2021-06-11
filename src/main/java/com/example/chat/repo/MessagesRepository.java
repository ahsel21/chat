package com.example.chat.repo;

import com.example.chat.domain.Messages;
import com.example.chat.domain.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer> {
    List<Messages> findMessagesByAuthor(Integer user_id);

    List<Messages> findMessagesByRooms(Integer room_id);

    List<Messages> findAll();

    @Query(value = "SELECT m FROM Messages m WHERE m.rooms.room_id = ?1")
    List<Messages> findAllByRoom_id(Integer room_id);

    @Override
    void delete(Messages messages);
}
