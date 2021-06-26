create table room_role
(
    id   bigserial    not null
        constraint room_role_pkey
        primary key,
    name varchar(255) not null
);

alter table room_role
    owner to postgres;