create table if not exists users (
id serial primary key,
name varchar not null,
last_name varchar not null,
birth_date date,
position varchar,
email varchar,
login varchar
);

create table if not exists contracts (
id serial primary key,
cipher_contract varchar not null,
name_contract varchar not null
);

create table if not exists businesTrips (
id serial primary key,
begin_trip date not null,
end_trip date not null
);