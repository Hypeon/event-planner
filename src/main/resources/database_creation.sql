

CREATE USER IF NOT EXISTS 'user'@'localhost:3306/event_planner' IDENTIFIED BY 'user';
GRANT ALL PRIVILEGES ON * . * TO 'user'@'localhost:3306/event_planner';
	

DROP DATABASE IF EXISTS`event_planner`;
CREATE DATABASE `event_planner`;
USE `event_planner`;

CREATE TABLE `location` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `address` varchar(80) NOT NULL,
  `lat` float(10,6) NOT NULL,
  `len` float(10,6) NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `event` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) NOT NULL,
  `datetime_of_event` datetime DEFAULT NULL,
  `price` decimal(7,2) NOT NULL,
  `location_id` int NOT NULL,
  -- CONSTRAINT contraint_name UNIQUE (id, email)
  -- `tag`
  PRIMARY KEY (`event_id`),
  CONSTRAINT location_event FOREIGN KEY (location_id) REFERENCES location(location_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;







