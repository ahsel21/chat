create table room
(
    id         bigserial    not null
        constraint room_pkey
        primary key,
    name       varchar(255) not null,
    is_private boolean,
    is_bot     boolean,
    is_deleted boolean
);

alter table room
    owner to postgres;

