package com.example.chat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
@Getter
@Setter
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Message> messages;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoleRoomUser> roleRoomUsers;

    @Column(name = "is_private", nullable = false)
    private boolean privateRoom;


    @Column(name = "is_bot", nullable = false)
    private boolean botRoom;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;

}