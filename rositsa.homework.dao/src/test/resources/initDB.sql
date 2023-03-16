CREATE DATABASE `homework` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `homework`;

CREATE TABLE `parkingevent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `plateNumber` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime DEFAULT NULL,
  `spentTime` int(11) DEFAULT '0',
  `paidSumm` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

INSERT INTO `homework`.`parkingevent`(`plateNumber`,`type`,`startTime`) VALUES ('CA9240A', 'CAR', '2023-03-16 12:00:00');
INSERT INTO `homework`.`parkingevent`(`plateNumber`,`type`,`startTime`) VALUES ('CB6495CA', 'BUS', '2023-03-16 20:30:00');
