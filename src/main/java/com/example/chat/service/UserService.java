package com.example.chat.service;

import com.example.chat.domain.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Users addUser(Users user);
    void deleteById(Integer id);
    Users findByLogin(String login);
    Optional<Users> findById(Integer id);
    Users editUser(Users user);
    List<Users> findAll();
    void save(Users user);
}
