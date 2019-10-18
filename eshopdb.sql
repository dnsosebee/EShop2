DROP SCHEMA IF EXISTS eshopdb;
CREATE SCHEMA IF NOT EXISTS eshopdb;
USE eshopdb;

CREATE TABLE Shopusers(
	user_id INT NOT NULL auto_increment,
    name VARCHAR(50),
    surname VARCHAR(50),
    email VARCHAR(50),
    address VARCHAR(120),
    password VARCHAR(50),
    PRIMARY KEY (user_id)
);

INSERT INTO users
VALUES (1, 'test', 'user', 'tester@gmail.com', '123 Smith St.', '123456');
