package com.example.chat.domain.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "Room")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @NotNull
    @Column(name = "ROOM_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer room_id;

    @NotBlank
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "PUBLIC_ACCESS", nullable = false)
    private Boolean public_access;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OWNER_ID")
    private User owner_id;


//    @ManyToMany (cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "CHAT_USERS",
//            joinColumns = @JoinColumn(name = "ROOM_ID"),
//            inverseJoinColumns = @JoinColumn(name = "USER_ID")
//    )
//    private List<User> users=new ArrayList<>();
//
//    @ManyToMany (cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "CHAT_USERS",
//            joinColumns = @JoinColumn(name = "USER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
//    )
//    private List<Role> roles=new ArrayList<>();

    @Override
    public int hashCode() {
        return Objects.hash(room_id, name, public_access, owner_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(room_id, room.room_id) && Objects.equals(name, room.name) && Objects.equals(public_access, room.public_access) && Objects.equals(owner_id, room.owner_id);
    }

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", name='" + name + '\'' +
                ", public_access=" + public_access +
                ", owner_id=" + owner_id +
                '}';
    }
}
