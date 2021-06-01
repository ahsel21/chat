package com.example.chat.repo;

import com.example.chat.domain.Roles;
import com.example.chat.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@EnableJpaRepositories
@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {

    Roles findByName(String name);
    List<Roles> findAll();
    Set<Roles> findByUsers(Users user);


}
