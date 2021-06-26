package com.example.chat.repositories;

import com.example.chat.model.RoleRoomUser;
import com.example.chat.model.Room;
import com.example.chat.model.RoomRole;
import com.example.chat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRoomUserRepository extends JpaRepository<RoleRoomUser, Long> {

    List<RoleRoomUser> findByUser(User user);

    List<RoleRoomUser> findAllByUserAndRole(User user, RoomRole role);

    List<RoleRoomUser> findAllByUserAndRoom(User user, Room room);

}
