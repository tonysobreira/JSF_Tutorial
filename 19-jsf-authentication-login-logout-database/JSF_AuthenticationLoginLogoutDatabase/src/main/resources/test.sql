DROP TABLE users;

CREATE TABLE users ( 
id int(20) NOT NULL AUTO_INCREMENT, 
username VARCHAR(60) NOT NULL, 
password VARCHAR(60) NOT NULL, 
PRIMARY KEY(id));

INSERT INTO users VALUES(1,'admin','admin');
