create table if not exists USERS (
id serial primary key,
name varchar not null,
last_name varchar not null,
birth_date date,
position varchar,
email varchar,
login varchar
);

create table if not exists CONTRACTS (
id serial primary key,
cipher_contract varchar not null,
name_contract varchar not null,
);