package com.example.chat.services.impl;

import com.example.chat.dto.MessageDTO;
import com.example.chat.filter.specification.UserSpecification;
import com.example.chat.model.Message;
import com.example.chat.model.Room;
import com.example.chat.model.User;
import com.example.chat.repositories.MessageRepository;
import com.example.chat.services.MessageService;
import com.example.chat.services.RoleRoomUserService;
import com.example.chat.services.RoomService;
import com.example.chat.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    private final UserService userService;

    private final RoomService roomService;

    private final RoleRoomUserService roleRoomUserService;

    private final ModelMapper modelMapper;

    @Transactional
    public MessageDTO save(MessageDTO messageDTO, String username) {
        User user = modelMapper.map(userService.findUserByUsername(UserSpecification.findByUsername(username)), User.class);
        Room room = modelMapper.map(roomService.findById(messageDTO.getRoom().getId()), Room.class);
        if (!roleRoomUserService.findAllByUserAndRoom(user, room).isEmpty()) {
            Message message = modelMapper.map(messageDTO, Message.class);
            message.setCreatedDateTime(ZonedDateTime.now());
            message.setAuthor(user);

            message.setRoom(room);

            messageRepository.save(message);
            return convertToDTO(message);
        }
        throw new IllegalArgumentException();
    }

    @Transactional
    public List<MessageDTO> findAll() {
        return messageRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private MessageDTO convertToDTO(Message message) {
        return modelMapper.map(message, MessageDTO.class);
    }


}
