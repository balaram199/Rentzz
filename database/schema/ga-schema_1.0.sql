drop schema if exists grabassetdb;

create database if not exists grabassetdb;
use grabassetdb;

/*
	drop script
*/

drop table if exists order_product;
drop table if exists rented_products;

drop table if  exists product_lease_agreement;
drop table if exists rent;
drop table if exists product_maintainance;

drop table if exists user_rental_packages;
drop table if exists member_feedback;
drop table if exists user_details;
drop table if exists user;
drop table if exists owner;
drop table if exists product;
drop table if exists rental_package_categories;


drop table if exists category;
drop table if exists rental_package;
drop table if exists country;
drop table if exists state;
drop table if exists city;
drop table if exists role;
drop table if exists address;

/*
	create script
*/

create  table if not exists country(
	country_id integer primary key not null ,
	country_nm varchar(40) not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

create  table if not exists state(
	state_id integer primary key not null ,
	state_nm varchar(40) not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

create  table if not exists city(
	city_id integer primary key not null ,
	city_nm varchar(40) not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);





create table if not exists role(
	role_id integer primary key not null,
	role_code varchar(3) not null,
	role_display_nm varchar(50) not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);


create table if not exists rental_package(
	rental_package_id integer primary key not null auto_increment,
	package_logo longblob ,
	package_logo_filename varchar(50),
	package_logo_type varchar(50),
	package_nm varchar(50) not null,
	description varchar(1000) not null,
	duration_in_hours integer ,
	no_of_products integer(5) not null,
	is_swappable tinyint not null,
	validity_in_days integer not null,
	amount numeric(7,2) not null,
	status varchar(1) not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null	
);

create table if not exists address(
	address_id integer primary key not null auto_increment,
	address_line1 varchar(50) not null,
	address_line2 varchar(50),
	city varchar(50) not null,
	state varchar(50) not null,
	zip varchar(6) not null,
	country varchar(50) not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

create table if not exists user(
	system_user_id integer primary key not null auto_increment,
	first_nm varchar(50) not null,
	last_nm varchar(50) not null,
	mobile_nbr varchar(15) not null unique,
	user_nm varchar(50) not null unique,
	password varchar(64) not null unique,
	role_id integer not null,
	activation_code varchar(6),
	status varchar(1) not null,
	registerd_dt date not null,
	activation_dt datetime null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

create table if not exists user_details(
	system_user_id integer primary key not null,
	identification_no varchar(50) not null,
	identification_type varchar(50) not null,
	user_address_id integer not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);
create table if not exists category(
	category_id integer primary key not null auto_increment,
	category_nm varchar(50) not null,
	description varchar(1000) not null,
	category_img longblob,
	category_img_filename varchar(50),
	category_img_type varchar(50),
	parent_category_id integer ,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

create table if not exists member_feedback(
	feedback_id integer primary key not null,
	user_id int not null,
	rating int(1) not null,
	comments varchar(500) not null,
	status varchar(1) not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

create table if not exists owner(
	owner_id integer primary key not null,
	first_nm varchar(50) not null,
	last_nm varchar(50) not null,
	contact_no varchar(15) not null,
	email_address varchar(50) not null unique,
	owner_address_id int not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

create table if not exists product(
	product_id integer primary key not null auto_increment,
	product_img longblob ,
	product_img_filename varchar(50) not null,
	product_img_type varchar(50) not null,
	title varchar(50) not null,
	description varchar(1000) not null,
	product_condition varchar(3) not null,
	age_in_months integer not null,
	category_id integer not null,
	security_deposit_amount numeric(7,2) not null,
	damage_cost numeric(7,2),
	owner_ship_type varchar(1) not null,
	rental_amount numeric(7,2) not null,
	status varchar(1) not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

create table if not exists product_lease_agreement(
	lease_agreement_id integer primary key not null auto_increment,
	product_id integer not null,
	owner_id int not null,
	lease_start_dt date,
	lease_end_dt date,
	amount numeric(7,2),
	damage_recovery_charges numeric(7,2),
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
	
);
create table if not exists rented_products(
	rent_id integer  not null,
	product_id integer not null,
	product_rented_dt datetime not null,
	product_returned_dt datetime not null,
	product_condition varchar(50) not null,
	damage_charges_collected numeric(7,2),
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

create table if not exists product_maintainance(
	product_maintainance_id integer not null primary key auto_increment,
	product_id integer not null,
	repair_description varchar(1000) not null,
	maintainance_charges numeric(7,2) ,
	vendor_nm varchar(50) not null,
	comments varchar(500),
	status varchar(6) not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null

);

create table if not exists rental_package_categories(
	rental_package_id integer primary key not null,
	category_id integer not null,
	late_fee_charges_per_hour numeric(7,2),
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);


create table if not exists user_rental_packages(
	user_rental_package_id integer primary key not null auto_increment,
	user_id integer not null,
	rental_package_id integer not null,
	purchase_dt date not null,
	status varchar(3) not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

create table if not exists rent(
	rent_id integer primary key not null,
	user_rental_package_id integer ,
	rented_dt datetime,
	returned_dt datetime,
	security_deposit_paid numeric(7,2),
	late_fee numeric(7,2) ,
	is_swaped tinyint not null,
	status varchar(7),
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);


create table if not exists order_product(
	order_id integer primary key not null auto_increment,
	user_id integer not null,	
	product_id integer not null,
	rental_package_id integer not null,
	created_by varchar(50) not null,
	created_dt timestamp not null,
	last_modified_by varchar(50) not null,
	last_modified_dt timestamp not null
);

/*
	foreign key 
*/

alter table user
add foreign key (role_id)
references role(role_id);




alter table user_details
add foreign key (system_user_id)
references user(system_user_id);

alter table user_details
add foreign key(user_address_id)
references address(address_id);

alter table category
add foreign key (parent_category_id)
references category(category_id);

alter table member_feedback
add foreign key (user_id)
references user(system_user_id);

alter table product 
add foreign key (category_id)
references category(category_id);

alter table owner
add foreign key (owner_address_id)
references address(address_id);


alter table product_lease_agreement
add foreign key (owner_id)
references owner(owner_id);

alter table product_lease_agreement
add foreign key(product_id)
references product(product_id);

alter table rented_products
add foreign key (rent_id)
references rent(rent_id);

alter table rented_products
add foreign key (product_id)
references product(product_id);


alter table product_maintainance
add foreign key (product_id)
references product(product_id);

alter table rental_package_categories
add foreign key (category_id)
references category(category_id);


alter table user_rental_packages
add foreign key (user_id)
references user(system_user_id);

alter table user_rental_packages
add foreign key (rental_package_id)
references rental_package(rental_package_id);


alter table rent
add foreign key (user_rental_package_id)
references user_rental_packages(user_rental_package_id);

alter table order_product
add foreign key (user_id)
references user(system_user_id);

alter table order_product
add foreign key (product_id)
references product(product_id);

alter table order_product
add foreign key (rental_package_id)
references rental_package(rental_package_id);