package com.example.chat.domain.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    //TODO Сделать сущность чата
    @Id
    @NotNull
    @Column(name = "ROOM_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer room_id;

    @NotBlank
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "PUBLIC_ACCESS", nullable = false)
    private Boolean public_access;

    @NotNull
    @Column(name = "OWNER_ID")
    private Integer owner_id;

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
