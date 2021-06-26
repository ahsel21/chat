create table message
(
    id                bigserial                not null
        constraint message_pkey
        primary key,
    user_id           bigint                   not null
        constraint fk_message_person
        references person,
    message_text      text                     not null,
    created_date_time timestamp with time zone not null,
    room_id           bigint
        constraint fk_message_room
        references room
);

alter table message
    owner to postgres;

