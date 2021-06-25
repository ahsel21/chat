package com.example.chat.repositories;

import com.example.chat.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long>, JpaSpecificationExecutor<Room> {

    @Query("select roleRoomUser.room from RoleRoomUser roleRoomUser " +
            "where roleRoomUser.role.name = :roomRoleName " +
            "and roleRoomUser.user.username = :username " +
            "and roleRoomUser.room.deleted = false ")
    List<Room> findAllByUsernameAndRoleName(String username, String roomRoleName);

    @Query("select  roleRoomUser.room from RoleRoomUser roleRoomUser  " +
            "where roleRoomUser.role.name = 'ROLE_ADMIN' " +
            "and roleRoomUser.user.username = :username " +
            "and roleRoomUser.room.name = :roomName " +
            "and roleRoomUser.room.deleted = false")
    List<Room> findAllByAdminUsernameAndRoomName(String username, String roomName);

}
