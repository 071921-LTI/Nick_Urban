


drop table customers cascade; 
--run statement above to drop, then run below to recreate
create table customers (
	id SERIAL primary key,
	user_name varchar(50) unique not null,
	pass varchar(50) not null,
	is_employee boolean -- NEEDS WORK
);

insert into customers (user_name, pass, is_employee) values ('joe', 'password', false);
insert into customers (user_name, pass, is_employee) values ('bill', 'password', false);
insert into customers (user_name, pass, is_employee) values ('rob', 'password', false);
truncate customers cascade;
--ALTER SEQUENCE customers id RESTART WITH 1;

drop table employees cascade;
--run statement above to drop, then run below to recreate
create table employees (
	id SERIAL primary key,
	user_name varchar(50) unique not null,
	pass varchar(50) not null,
	is_employee boolean
);

insert into employees (user_name, pass, is_employee) values ('zack', 'password', true); 
insert into employees (user_name, pass, is_employee) values ('rob', 'pass', true);
insert into employees (user_name, pass, is_employee) values ('russ', 'pass', true);



drop table items cascade;
--run statement above to drop, then run below to recreate
create table items (
	id SERIAL primary key,
	description varchar(75) not null,
	asking_price numeric(7,2) not null,
	sold_price numeric(7,2),
	weekly_payments numeric(7,2),
	remaining_balance numeric(7,2),
	payment_amount numeric(7,2),
	is_owned boolean,
	owner_id int references customers (id)
);

insert into items 
(description, asking_price, sold_price, weekly_payments, remaining_balance, payment_amount, is_owned, owner_id)
values ('jvm', 700.00, 0, 0, 0, 0, false, null);
insert into items 
(description, asking_price, sold_price, weekly_payments, remaining_balance, payment_amount, is_owned, owner_id)
values ('jdk', 500.00, 0, 0, 0, 0, false, null);

--alter table items add column owner_id int references customers (id);



