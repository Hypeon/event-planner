CREATE DATABASE  IF NOT EXISTS `event_planner`;
USE `event_planner`;

CREATE TABLE `event` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `datetime_of_event` datetime DEFAULT CURRENT_TIMESTAMP,
  `price` decimal(7,2) DEFAULT NULL,
  -- CONSTRAINT contraint_name UNIQUE (id, email)
  -- `tag`
  `location_id` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (location_id) REFERENCES event(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `address` varchar(80) NOT NULL,
  `lat` float(10,6) NOT NULL,
  `lng` float(10,6) NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;