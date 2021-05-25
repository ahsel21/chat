package com.example.chat.repo;

import com.example.chat.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUser_id(Integer user_id);
    Users findByLogin(String login);
    List<Users> findAll();
    long count();

    @Override
    void delete(Users users);
    Users add(Users users);
    Users update(Users users);
}
