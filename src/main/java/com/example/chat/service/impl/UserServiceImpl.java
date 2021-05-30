package com.example.chat.service.impl;

import com.example.chat.domain.Users;
import com.example.chat.repo.UsersRepository;
import com.example.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    public Users addUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users findByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    @Override
    public Optional<Users> findById(Integer id) {
        return usersRepository.findById(id);
    }


    @Override
    public Users editUser(Users user) {
        return  usersRepository.save(user);
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public void save(Users user) {
        usersRepository.save(user);
    }

}
