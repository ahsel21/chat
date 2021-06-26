package com.example.chat.services.impl;

import com.example.chat.dto.UserDTO;
import com.example.chat.model.User;
import com.example.chat.repositories.UserRepository;
import com.example.chat.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public UserDTO findById(Long id) {
        return convertToDTO(userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("No user found with id " + id)));
    }

    @Transactional
    public UserDTO findUserByUsername(Specification<User> specification) {
        return convertToDTO(userRepository.findOne(specification).orElseThrow(() -> new EntityNotFoundException("No user found with username ")));
    }

    @Transactional
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

}
