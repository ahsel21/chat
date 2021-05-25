package com.example.chat.repo;

import com.example.chat.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    List<Roles> findAll();
    Roles findByName(String name);
    Roles findByRole_id(Integer role_id);
}
