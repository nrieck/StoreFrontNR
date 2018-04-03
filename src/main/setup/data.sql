drop table product;
drop table address;

create table product (
	id varchar(5) primary key,
	name varchar(50),
	price varchar(50)
);

create table address (
	id varchar(5) primary key,
	productid varchar(5),
	street varchar(50),
	city varchar(50),
	state varchar(2),
	zip varchar(5)
);

insert into product (id, name, price) values ('1', 'Cookies', '3.99');
insert into product (id, name, price) values ('2', 'Chips', '2.99');
insert into product (id, name, price) values ('3', 'Beer', '5.99');

insert into address (id, productid, street, city, state, zip)
values ('1', '1', '123 Main St', 'Springfield', 'WI', '54321');

insert into address (id, productid, street, city, state, zip)
values ('2', '2', '456 Miller Blvd', 'Asheville', 'NC', '12345');
