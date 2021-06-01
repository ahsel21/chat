package com.example.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "Roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Roles implements GrantedAuthority {

    @Id
    @NotNull
    @Column(name = "ROLE_ID", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer role_id;

    @NotBlank
    @Column(name = "NAME", unique = true)
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "chat_users",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private List<Users> users = new ArrayList<>();

//    public Roles(Integer role_id, String name) {
//        this.role_id = role_id;
//        this.name = name;
//    }


//    @ManyToMany(mappedBy = "USERS")
//    private List<User> users=new ArrayList<>();


    @Override
    public String toString() {
        return "Roles{" +
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
        Roles roles = (Roles) o;
        return Objects.equals(role_id, roles.role_id) && Objects.equals(name, roles.name) && Objects.equals(send_message, roles.send_message) && Objects.equals(recive_message, roles.recive_message) && Objects.equals(delete_message, roles.delete_message) && Objects.equals(create_rooms, roles.create_rooms) && Objects.equals(add_users, roles.add_users) && Objects.equals(delete_users, roles.delete_users) && Objects.equals(rename_rooms, roles.rename_rooms) && Objects.equals(ban_users, roles.ban_users) && Objects.equals(set_moderators, roles.set_moderators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role_id, name, send_message, recive_message, delete_message, create_rooms, add_users, delete_users, rename_rooms, ban_users, set_moderators);
    }

    @Override
    public String getAuthority() {
        return getName();
    }

}
