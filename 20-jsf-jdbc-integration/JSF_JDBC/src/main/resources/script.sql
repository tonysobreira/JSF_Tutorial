CREATE DATABASE cardb;

USE cardb;

CREATE TABLE Car(
	car_id INTEGER NOT NULL AUTO_INCREMENT,
	cname VARCHAR(60) NOT NULL,
	color VARCHAR(60),
	speed INTEGER,
	Manufactured_Country VARCHAR(100),
	PRIMARY KEY(car_id));
	
INSERT INTO Car VALUES(1,'Zen','Grey',45.34,'India');
INSERT INTO Car VALUES(2,'Volkswagen','Black',49.64,'Germany');
INSERT INTO Car VALUES(3,'Polo','White',52.33,'Japan');
INSERT INTO Car VALUES(4,'Audi','Blue',55.98,'Germany');
INSERT INTO Car VALUES(5,'Innova','Maroon',39.97,'France');
INSERT INTO Car VALUES(6,'FiatPalio','Silver',35.45,'Italy');
INSERT INTO Car VALUES(7,'Qualis','Red',23.35,'Paris');

