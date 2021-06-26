package com.example.chat.repositories;

import com.example.chat.model.RoomRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRoleRepository extends JpaRepository<RoomRole, Long>, JpaSpecificationExecutor<RoomRole> {
}
