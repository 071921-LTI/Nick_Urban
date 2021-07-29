


drop table customers; 
--run statement above to drop, then run below to recreate
create table customers (
	id int primary key,
	user_name varchar(50),
	pass varchar(50),
	is_employee bool
);

drop table employees;
--run statement above to drop, then run below to recreate
create table employees (
	id int primary key,
	user_name varchar(50),
	pass varchar(50),
	is_employee bool
);

drop table items;
--run statement above to drop, then run below to recreate
create table items (
	id int primary key,
	description varchar(75),
	asking_price numeric(7,2),
	sold_price numeric(7,2),
	weekly_payments numeric(7,2),
	remaining_balance numeric(7,2),
	payment_amount numeric(7,2),
	is_owned bool
);