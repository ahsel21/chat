package com.example.chat.service.impl;

import com.example.chat.domain.Roles;
import com.example.chat.domain.Users;
import com.example.chat.repo.RolesRepository;
import com.example.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService userService;


    @Override
    public Users addUser(Users user) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Users getByLogin(String login) {
        return null;
    }

    @Override
    public Users editUser(Users user) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return userService.findAll();
        //return null;
    }
}
