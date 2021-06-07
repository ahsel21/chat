create table rooms
(
    room_id       integer      not null
        constraint rooms_pkey
            primary key,
    name          varchar(255) not null
        constraint uk_1kuqhbfxed2e8t571uo82n545
            unique,
    public_access boolean      not null,
    owner_id      integer      not null
        constraint fktnhxhxjvamaungwsm0q7e010
            references users
);

alter table rooms
    owner to postgres;