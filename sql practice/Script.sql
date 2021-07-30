


drop table customers; 
--run statement above to drop, then run below to recreate
create table customers (
	id SERIAL primary key,
	user_name varchar(50) unique not null,
	pass varchar(50) not null,
	is_employee bool
);

drop table employees;
--run statement above to drop, then run below to recreate
create table employees (
	id SERIAL primary key,
	user_name varchar(50) unique not null,
	pass varchar(50) not null,
	is_employee bool
);

drop table items;
--run statement above to drop, then run below to recreate
create table items (
	id SERIAL primary key,
	description varchar(75) not null,
	asking_price numeric(7,2) not null,
	sold_price numeric(7,2),
	weekly_payments numeric(7,2),
	remaining_balance numeric(7,2),
	payment_amount numeric(7,2),
	is_owned bool,
	owner_id int references customers (id)
);

--alter table items add column owner_id int references customers (id);