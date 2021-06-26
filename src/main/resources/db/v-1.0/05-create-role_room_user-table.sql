create table role_room_user
(
    id      bigserial not null
        constraint role_room_user_pkey
        primary key,
    role_id bigint    not null
        constraint fk_role_role_room_user
        references room_role,
    room_id bigint    not null
        constraint fk_room_role_room_user
        references room,
    user_id bigint    not null
        constraint fk_use_role_room_user
        references person
);

alter table role_room_user
    owner to postgres;