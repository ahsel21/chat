create table users
(
    user_id  integer      not null
        constraint users_pkey
        primary key,
    login    varchar(255) not null,
    password varchar(255)
);


alter table users
    owner to postgres;

