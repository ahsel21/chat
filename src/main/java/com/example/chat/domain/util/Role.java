package com.example.chat.domain.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "Role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {


    @Id
    @NotNull
    @Column(name = "ROLE_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer role_id;

    @NotBlank
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @NotNull
    @Column(name = "SEND_MESSAGE", nullable = false)
    private Boolean send_message = false;

    @NotNull
    @Column(name = "RECIVE_MESSAGE", nullable = false)
    private Boolean recive_message = false;

    @NotNull
    @Column(name = "DELETE_MESSAGE", nullable = false)
    private Boolean delete_message = false;

    @NotNull
    @Column(name = "CREATE_ROOMS", nullable = false)
    private Boolean create_rooms = false;

    @Column(name = "ADD_USERS", nullable = false)
    @NotNull
    private Boolean add_users = false;

    @NotNull
    @Column(name = "DELETE_USERS", nullable = false)
    private Boolean delete_users = false;

    @NotNull
    @Column(name = "RENAME_ROOMS", nullable = false)
    private Boolean rename_rooms = false;

    @NotNull
    @Column(name = "BAN_USERS", nullable = false)
    private Boolean ban_users = false;

    @NotNull
    @Column(name = "SET_MODERATORS", nullable = false)
    private Boolean set_moderators = false;

//    @ManyToMany(mappedBy = "USERS")
//    private List<User> users=new ArrayList<>();


    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", name='" + name + '\'' +
                ", send_message=" + send_message +
                ", recive_message=" + recive_message +
                ", delete_message=" + delete_message +
                ", create_rooms=" + create_rooms +
                ", add_users=" + add_users +
                ", delete_users=" + delete_users +
                ", rename_rooms=" + rename_rooms +
                ", ban_users=" + ban_users +
                ", set_moderators=" + set_moderators +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(role_id, role.role_id) && Objects.equals(name, role.name) && Objects.equals(send_message, role.send_message) && Objects.equals(recive_message, role.recive_message) && Objects.equals(delete_message, role.delete_message) && Objects.equals(create_rooms, role.create_rooms) && Objects.equals(add_users, role.add_users) && Objects.equals(delete_users, role.delete_users) && Objects.equals(rename_rooms, role.rename_rooms) && Objects.equals(ban_users, role.ban_users) && Objects.equals(set_moderators, role.set_moderators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role_id, name, send_message, recive_message, delete_message, create_rooms, add_users, delete_users, rename_rooms, ban_users, set_moderators);
    }
}
