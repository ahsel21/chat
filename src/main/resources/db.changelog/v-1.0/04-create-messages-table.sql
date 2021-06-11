create table messages
(
    message_id integer not null
        constraint messages_pkey
        primary key,
    text       varchar(2048),
    user_id    integer not null
        constraint fkpsmh6clh3csorw43eaodlqvkn
        references users,
    room_id    integer
        constraint fk92hs6y8g4al98ihp4ms6nbxeq
        references rooms
);

alter table messages
    owner to postgres;