package com.example.chat.services.impl;

import com.example.chat.model.Message;
import com.example.chat.model.RoleRoomUser;
import com.example.chat.model.User;
import com.example.chat.repositories.RoomRepository;
import com.example.chat.repositories.RoomRoleRepository;
import com.example.chat.repositories.UserRepository;
import com.example.chat.services.RoleRoomUserService;
import com.example.chat.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final RoomRoleRepository roomRoleRepository;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    private final RoleRoomUserService roleRoomUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = modelMapper.map(userService.findUserByUsername(com.example.chat.filter.specification.UserSpecification.findByUsername(username)), User.class);

        if (Objects.nonNull(user)) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    mapRolesToAuthorities(user));
        }
        throw new UsernameNotFoundException("Invalid username or password.");
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(User user) {
        return roleRoomUserService
                .findByUser(user)
                .stream()
                .map(roleRoomUser -> new SimpleGrantedAuthority(roleRoomUser.getRole().getAuthority()))
                .collect(Collectors.toSet());
    }

    public void save(User user) {
        List<Message> messageList = new ArrayList<>();
        Message message = new Message();
        message.setMessageText("Hello, I am " + user.getUsername());
        message.setAuthor(user);
        message.setRoom(roomRepository.getOne(1L));
        messageList.add(message);
        user.setMessages(messageList);
        user.setEmail(user.getEmail() + "@gmail.com");
        RoleRoomUser roleRoomUser = new RoleRoomUser();
        roleRoomUser.setRoom(roomRepository.getOne(1L));
        roleRoomUser.setUser(user);
        roleRoomUser.setRole(roomRoleRepository.getOne(1L));
        List<RoleRoomUser> roleRoomUserList = new ArrayList<>();
        roleRoomUserList.add(roleRoomUser);
        user.setRoleRoomUsers(roleRoomUserList);
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }
}
