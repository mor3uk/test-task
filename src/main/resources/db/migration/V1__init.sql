create table if not exists users
(
    id int not null,
    login varchar not null,
    first_name varchar not null,
    last_name varchar not null,
    middle_name varchar,
    email varchar
);