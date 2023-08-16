create table if not exists USERS (
id serial primary key,
name varchar not null,
last_name varchar not null,
birth_date date,
position varchar,
email varchar,
login varchar
);