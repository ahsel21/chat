package com.example.chat.domain.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Table(name = "Rooms")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rooms {
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "OWNER_ID")
    private Users owner_id;


//    @ManyToMany (cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "CHAT_USERS",
//            joinColumns = @JoinColumn(name = "ROOM_ID"),
//            inverseJoinColumns = @JoinColumn(name = "USER_ID")
//    )
//    private List<Users> users=new ArrayList<>();

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
        Rooms rooms = (Rooms) o;
        return Objects.equals(room_id, rooms.room_id) && Objects.equals(name, rooms.name) && Objects.equals(public_access, rooms.public_access) && Objects.equals(owner_id, rooms.owner_id);
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "room_id=" + room_id +
                ", name='" + name + '\'' +
                ", public_access=" + public_access +
                ", owner_id=" + owner_id +
                '}';
    }
}
