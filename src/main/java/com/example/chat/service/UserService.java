package com.example.chat.service;

import com.example.chat.domain.Users;

import java.util.List;

public interface UserService {
    Users addUser(Users user);
    void delete(Integer id);
    Users getByLogin(String login);
    Users editUser(Users user);
    List<Users> findAll();
}
