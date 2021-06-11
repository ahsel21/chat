package com.example.chat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "Messages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Messages {

    @Id
    @NotNull
    @Column(name = "MESSAGE_ID", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer message_id;

    @NotBlank
    @Column(name = "TEXT", length = 2048)
    private String text;


    @JoinColumn(name = "USER_ID")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @NotNull
    private Users author;


    @JoinColumn(name = "ROOM_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Rooms rooms;


    @NotNull
    @Column(name = "DATE")
    private Date date;


    public void setDate() {
        this.date = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messages messages = (Messages) o;
        return Objects.equals(message_id, messages.message_id) && Objects.equals(text, messages.text) && Objects.equals(author, messages.author) && Objects.equals(rooms, messages.rooms) && Objects.equals(date, messages.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message_id, text, author, rooms, date);
    }

    @Override
    public String toString() {
        return "Messages{" +
                "message_id=" + message_id +
                ", text='" + text + '\'' +
                ", author=" + author +
                ", rooms=" + rooms +
                ", date=" + date +
                '}';
    }
}