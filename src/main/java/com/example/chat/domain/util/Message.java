package com.example.chat.domain.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity(name = "planner_Message")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message{

    @Id
    @NotNull
    @Column(name = "MESSAGE_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer message_id;

    @NotBlank
    @Column(name = "TEXT", nullable = false, length = 2048)
    private String text;

    @NotNull
    @Column(name = "AUTHOR", nullable = false)
    private Integer author;

    @NotNull
    @Column(name = "ROOM_ID", nullable = false)
    private Integer room_id;

    @Override
    public int hashCode() {
        return Objects.hash(message_id, text, author, room_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(message_id, message.message_id) && Objects.equals(text, message.text) && Objects.equals(author, message.author) && Objects.equals(room_id, message.room_id);
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", text='" + text + '\'' +
                ", author=" + author +
                ", room_id=" + room_id +
                '}';
    }
}