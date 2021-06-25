package com.example.chat.services;

import com.example.chat.dto.UserDTO;
import com.example.chat.model.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface UserService {


    UserDTO findById(Long id);

    UserDTO findUserByUsername(Specification<User> specification);

    List<UserDTO> findAll();

}
