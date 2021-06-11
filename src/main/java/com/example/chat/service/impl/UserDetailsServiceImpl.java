package com.example.chat.service.impl;

import com.example.chat.domain.Roles;
import com.example.chat.domain.Users;
import com.example.chat.repo.UsersRepository;
import com.example.chat.service.RolesService;
import com.example.chat.service.RoomsService;
import com.example.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    public static final String MAIN_ROOM = "MAIN";
    @Autowired
    private final UserService userService;

    @Autowired
    private UsersRepository usersRepository;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;


    private final RolesService rolesService;

    private final RoomsService roomsService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findByLogin(username);

        if (Objects.nonNull(user)) {
            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    mapRolesToAuthorities(user));
        }
        throw new UsernameNotFoundException("Invalid username or password.");
    }
    @Transactional
    public Collection<? extends GrantedAuthority> mapRolesToAuthorities(Users user) {
        return rolesService
                .findByUsers(user)
                .stream()
                .map(userRoles -> new SimpleGrantedAuthority(userRoles.getAuthority()))
                .collect(Collectors.toSet());
    }
    @Transactional
    public void save(Users user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userService.save(user);
    }

}