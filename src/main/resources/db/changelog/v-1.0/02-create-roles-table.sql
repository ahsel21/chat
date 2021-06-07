-- auto-generated definition
create table roles
(
    role_id        integer not null
        constraint roles_pkey
        primary key,
    add_users      boolean not null,
    ban_users      boolean not null,
    create_rooms   boolean not null,
    delete_message boolean not null,
    delete_users   boolean not null,
    name           varchar(255)
        constraint uk_ofx66keruapi6vyqpv6f2or37
        unique,
    recive_message boolean not null,
    rename_rooms   boolean not null,
    send_message   boolean not null,
    set_moderators boolean not null
);

alter table roles
    owner to postgres;

