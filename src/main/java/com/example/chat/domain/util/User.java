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
public class User {

    @Id
    @NotNull
    @Column(name = "USER_ID", nullable = false, unique = true)
    private Integer user_id;

    @NotBlank
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Override
    public int hashCode() {
        return Objects.hash(user_id, login, password);
    }
}
