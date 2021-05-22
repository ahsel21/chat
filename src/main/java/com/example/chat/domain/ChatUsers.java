package com.example.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "chat_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer chat_users_id;

    @JoinColumn(name = "ROOM_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Rooms room;

    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Users user;

    @JoinColumn(name = "ROLE_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private Roles role;


}