package com.example.chat.repo;

import com.example.chat.domain.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {

    Rooms findByName(String name);

    List<Rooms> findAll();

    long count();

    @Query(value = "SELECT r FROM Rooms r WHERE r.owner_id.user_id = ?1")
    List<Rooms> getRoomsByOwnerId(Integer owner_id);

    @Query(value = "SELECT r FROM Rooms r WHERE r.name = ?1")
    List<Rooms> getRoomsByName(String roomName);


}
