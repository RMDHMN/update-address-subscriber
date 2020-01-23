CREATE USER 'app'@'localhost' IDENTIFIED BY 'app';

CREATE DATABASE SUBSCRIBER;

GRANT ALL PRIVILEGES ON SUBSCRIBER.* TO 'app'@'localhost';

USE SUBSCRIBER;

CREATE TABLE subscriber (
id_subscriber BINARY(16) PRIMARY KEY,
first_name  varchar(25),
last_name varchar(25)
) ENGINE=InnoDB;

CREATE TABLE contract (
id_contract BINARY(16) PRIMARY KEY,
id_subscriber BINARY(16),
name  varchar(25),
description varchar(25),
CONSTRAINT fk_subscriber_contract
FOREIGN KEY (id_subscriber)
REFERENCES subscriber(id_subscriber)
) ENGINE=InnoDB;

CREATE TABLE address (
id_address BINARY(16) PRIMARY KEY,
address  varchar(25),
zip_code varchar(25),
city varchar(25),
country varchar(25),
CONSTRAINT fk_contract_address
FOREIGN KEY (id_address)
REFERENCES contract(id_contract)
) ENGINE=InnoDB;
