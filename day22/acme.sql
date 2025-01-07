-- drop the database if exists
drop database if exists acme;

-- create the database
-- create database if not exists acme;
create database acme;

-- select the database
use acme;

-- create one or more tables
select "Creating employees table..." as msg;
create table employees (
    emp_id char(8) not null, -- this is the PK
    name varchar(128) not null,
    salary decimal(10, 2) default 4500,
    dob date not null,
    dept_id int,

    constraint chk_salary check(salary >= 1500),
    constraint pk_emp_id primary key(emp_id)
);

-- create dept
select "Creating dept table..." as msg;
create table dept (
    dept_id int auto_increment,
    name varchar(64) not null,

    constraint pk_dept_id primary key(dept_id)
);

-- grant fred access to the database
select "Grant privileges to fred" as msg;
grant all privileges on acme.* to 'fred'@'%';
flush privileges;
