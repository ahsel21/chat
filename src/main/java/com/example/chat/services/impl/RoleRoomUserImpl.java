package com.example.chat.services.impl;

import com.example.chat.dto.RoleRoomUserDTO;
import com.example.chat.model.RoleRoomUser;
import com.example.chat.model.Room;
import com.example.chat.model.RoomRole;
import com.example.chat.model.User;
import com.example.chat.repositories.RoleRoomUserRepository;
import com.example.chat.services.RoleRoomUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleRoomUserImpl implements RoleRoomUserService {

    private final RoleRoomUserRepository roleRoomUserRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public List<RoleRoomUser> findByUser(User user) {
        return roleRoomUserRepository.findByUser(user);
    }

    @Transactional
    public RoleRoomUserDTO save(RoleRoomUser roleRoomUser) {
        return modelMapper.map(roleRoomUserRepository.save(roleRoomUser), RoleRoomUserDTO.class);
    }

    @Transactional
    public List<RoleRoomUserDTO> findAllByUserAndRole(User user, RoomRole role) {
        return roleRoomUserRepository.findAllByUserAndRole(user, role).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Transactional
    public List<RoleRoomUserDTO> findAllByUserAndRoom(User user, Room room) {
        return roleRoomUserRepository.findAllByUserAndRoom(user, room).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private RoleRoomUserDTO convertToDTO(RoleRoomUser roleRoomUser) {
        return modelMapper.map(roleRoomUser, RoleRoomUserDTO.class);
    }
}
