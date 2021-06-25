package com.example.chat.services.impl;

import com.example.chat.dto.RoomRoleDTO;
import com.example.chat.filter.specification.RoomRoleSpecification;
import com.example.chat.model.RoomRole;
import com.example.chat.repositories.RoomRoleRepository;
import com.example.chat.services.RoomRoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class RoomRoleServiceImpl implements RoomRoleService {

    private final RoomRoleRepository roomRoleRepository;

    private final ModelMapper modelMapper;

    @Override
    public RoomRoleDTO findByName(String name) {
        return convertToDTO(roomRoleRepository.findOne(RoomRoleSpecification.findByName(name))
                .orElseThrow(() -> new EntityNotFoundException("No room found with name ")));
    }


    private RoomRoleDTO convertToDTO(RoomRole roomRole) {
        return modelMapper.map(roomRole, RoomRoleDTO.class);
    }


}
