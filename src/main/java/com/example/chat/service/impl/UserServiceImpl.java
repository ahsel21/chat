package com.example.chat.service.impl;

import com.example.chat.domain.Roles;
import com.example.chat.domain.Users;
import com.example.chat.repo.RolesRepository;
import com.example.chat.repo.UsersRepository;
import com.example.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;


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
