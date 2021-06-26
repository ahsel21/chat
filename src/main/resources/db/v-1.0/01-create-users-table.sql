create table person
(
    id       bigserial    not null
        constraint person_pkey
        primary key,
    username varchar(255) not null
        constraint person_username_key
        unique,
    password varchar(255) not null,
    email    varchar(255) not null
        constraint person_email_key
        unique
);

alter table person
    owner to postgres;
