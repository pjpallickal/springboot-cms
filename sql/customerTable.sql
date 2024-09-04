CREATE DATABASE IF NOT EXISTS `customer_directory`;
USE `customer_directory`;

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
	`customer_id` int NOT NULL AUTO_INCREMENT,
    `customer_name` varchar(50) DEFAULT NULL,
    `customer_dob` date DEFAULT NULL,
    `customer_address` varchar(70) DEFAULT NULL,
    `customer_city` varchar(20) DEFAULT NULL,
    `customer_pin` varchar(10) DEFAULT NULL,
    `customer_contact` varchar(15) DEFAULT NULL,
    `customer_email` varchar(30) DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `customer` VALUES
	(1, "John Doe", "1999-08-11", "Indranagar 3rd Cross", "Bangalore", "560021", "9876543210", "johndoe@gmail.com"),
    (2, "Jerry Smith", "1995-10-01", "MG Road", "Bangalore", "560001", "9876501234", "jerrysmith@yahoo.com");