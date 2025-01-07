drop database if exists party;

create database party;

use party;

create table rsvps (
    rsvp_id int auto_increment,
    email varchar(128) not null,
    phone varchar(32) not null,
    confirm_date date default (current_date()),
    comments text,

    constraint pk_rsvp_id primary key(rsvp_id)
);

insert into rsvps(email, phone, confirm_date, comments) values
    ('fred@gmail.com', '12345678', '2025-01-10', 'I will be there'),
    ('barney@gmail.com', '4567890', '2025-01-09', ''),
    ('wilma@gmail.com', '12345678', '2025-01-30', 'I will be coming with Fred'),
    ('betty@gmail.com', '67890123', '2025-01-30', '');

create user 'fred'@'%' identified by 'fred';

grant all privileges on party.* to 'fred'@'%';
flush privileges;
