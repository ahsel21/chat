package com.example.chat.repo;

import com.example.chat.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    //List<Roles> findAll();
    Roles findByName(String name);

}
