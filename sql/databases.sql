drop schema if exists inventory;
create schema inventory;
use inventory;

drop schema if exists price;
create schema price;
use price;

drop schema if exists edge;
create schema edge;
use edge;

drop schema if exists store_product;
create schema store_product;
use store_product;

create table store_product (
	id int auto_increment not null,
    product_name varchar(255),
    price decimal (19,2),
    currency varchar(255),
    primary key (id)
);

insert into store_product (product_name, price, currency) values
 ("Platano", 5.4, "USD"),
 ("Pera", 3.2, "USD"),
 ("Fresa", 2.7, "USD");
 
drop schema if exists advertisement;
create schema advertisement;
use advertisement;

create table advertisement (
	id int auto_increment not null,
	vendor varchar(255),
    text varchar(255),
    primary key(id)
);

insert into advertisement (vendor, text) values 
("Pollos Hermanos", "te gusta el pollo frito? tenemos pollo frito"),
("Compramos tu coche", "Compramos tu coche, Compramos tu coche, Compramos tu coche..."),
("Helado Oscuro", "Pasate al helado oscuro"),
("Fruteria Loli", "Los mejores pepinos de toda la sierra");

drop schema if exists people;
create schema people;
use people;

CREATE TABLE people (
	id INT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255),
    phoneNumber VARCHAR(255),
    PRIMARY KEY (id)
);
INSERT INTO people (name, phoneNumber) VALUES
	("LeChuck", "454317468"),
    ("Guybrush Threepwood", "412895678"),
    ("Elaine Marley", "458963217"),
    ("George Stobbart", "689523458"),
    ("Nicole Collard", "651247845");

 
 