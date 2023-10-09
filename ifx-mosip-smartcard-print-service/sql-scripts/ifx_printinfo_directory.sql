CREATE DATABASE  IF NOT EXISTS `ifx_printinfo_directory`;
USE `ifx_printinfo_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `IFXPrintInfo`;

CREATE TABLE `IFXPrintInfo` (
  `uin` BIGINT NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `photo` varchar(100000) DEFAULT NULL,
  `qrcode` varchar(100000) DEFAULT NULL,
  PRIMARY KEY (`uin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

--INSERT INTO `employee` VALUES 
--	(1,'Leslie','Andrews','leslie@luv2code.com'),
--	(2,'Emma','Baumgarten','emma@luv2code.com'),
--	(3,'Avani','Gupta','avani@luv2code.com'),
--	(4,'Yuri','Petrov','yuri@luv2code.com'),
--	(5,'Juan','Vega','juan@luv2code.com');

