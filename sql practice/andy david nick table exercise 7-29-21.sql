-- table exercise 7-29-21

create table employees (
	id SERIAL primary key,
	first_name varchar(50),
	last_name varchar(50),
	dob date,
	sales_office int references sales_offices
	
);

create table sales_offices (
	id SERIAL primary key,
	street_address varchar(100),
	city varchar(50),
	state varchar(2),
	zip_code NUMERIC(5,0)
);

create table customers (
	id SERIAL primary key,
	first_name varchar(50),
	last_name varchar(50),
	dob date,
	employee int references employees
);