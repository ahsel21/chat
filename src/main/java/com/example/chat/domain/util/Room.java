package com.example.chat.domain.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @Column(name = "NAME", nullable = false, unique = true)
    private Integer name;

    @NotBlank
    @Column(name = "PUBLIC_ACCESS", nullable = false)
    private String public_access;

    @Column(name = "OWNER_ID")
    private String owner_id;

    @Override
    public int hashCode() {
        return Objects.hash(name, public_access, owner_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(name, room.name) &&
                Objects.equals(public_access, room.public_access) &&
                Objects.equals(owner_id, room.owner_id);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name=" + name +
                ", public_access='" + public_access + '\'' +
                ", owner_id='" + owner_id + '\'' +
                '}';
    }
}
