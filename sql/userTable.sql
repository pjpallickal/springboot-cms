CREATE DATABASE IF NOT EXISTS `user_directory`;
USE `user_directory`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`user_id` int NOT NULL AUTO_INCREMENT,
    `user_name` varchar(50) NOT NULL,
    `user_password` varchar(50) NOT NULL,
    `user_role` varchar(10) NOT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `user` VALUES
	(1, "johndoe", "password", "admin"),
    (2, "jerrysmith", "password", "admin");