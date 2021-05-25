package com.example.chat.repo;

import com.example.chat.domain.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
    Rooms findByRoom_id(Integer room_id);
    Rooms findByName(String name);
    List<Rooms> findAll();
    List<Rooms> findAllByOwner_id();

    long count();
    long countByPublic_accessIsFalse();
    long countByPublic_accessIsTrue();

    @Override
    void delete(Rooms rooms);
    Rooms add(Rooms rooms);
    Rooms update(Rooms rooms);
}
