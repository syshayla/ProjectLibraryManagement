-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.43-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema lms
--

CREATE DATABASE IF NOT EXISTS lms;
USE lms;

--
-- Definition of table `bookreturn`
--

DROP TABLE IF EXISTS `bookreturn`;
CREATE TABLE `bookreturn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `readerName` varchar(30) DEFAULT NULL,
  `isbn` varchar(30) DEFAULT NULL,
  `book_title` varchar(50) DEFAULT NULL,
  `issue_id` int(11) DEFAULT NULL,
  `DateOfReceive` date DEFAULT NULL,
  `returnQty` int(11) DEFAULT NULL,
  `availQty` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `issue_id` (`issue_id`),
  CONSTRAINT `bookreturn_ibfk_1` FOREIGN KEY (`issue_id`) REFERENCES `issue` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookreturn`
--

/*!40000 ALTER TABLE `bookreturn` DISABLE KEYS */;
INSERT INTO `bookreturn` (`id`,`readerName`,`isbn`,`book_title`,`issue_id`,`DateOfReceive`,`returnQty`,`availQty`) VALUES 
 (1,'Sumaiya','1212','Ma',1,'2019-04-11',1,555);
/*!40000 ALTER TABLE `bookreturn` ENABLE KEYS */;


--
-- Definition of table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `readerName` varchar(30) DEFAULT NULL,
  `contact` varchar(30) DEFAULT NULL,
  `book_title` varchar(50) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `DateIssue` date DEFAULT NULL,
  `DateExpiry` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `borrow_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `purchase` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrow`
--

/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;


--
-- Definition of table `issue`
--

DROP TABLE IF EXISTS `issue`;
CREATE TABLE `issue` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `readerName` varchar(30) DEFAULT NULL,
  `contact` varchar(30) DEFAULT NULL,
  `isbn` varchar(30) DEFAULT NULL,
  `book_title` varchar(50) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `issueQty` int(11) DEFAULT NULL,
  `availQty` int(11) DEFAULT NULL,
  `DateIssue` date DEFAULT NULL,
  `DateExpiry` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `issue_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `purchase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue`
--

/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` (`id`,`readerName`,`contact`,`isbn`,`book_title`,`book_id`,`issueQty`,`availQty`,`DateIssue`,`DateExpiry`) VALUES 
 (1,'Sumaiya','013456987','1212','Ma',1,1,49,'2019-04-11','2019-05-11'),
 (2,'Shima','09230284','1212','Ma',1,1,48,'2019-04-11','2019-11-05'),
 (3,'Smrity','01283923','1212','Ma',1,1,47,'2019-04-11','2019-06-11');
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;


--
-- Definition of table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `isbn` varchar(30) DEFAULT NULL,
  `authorname` varchar(30) DEFAULT NULL,
  `booktype` varchar(30) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchase`
--

/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` (`id`,`title`,`isbn`,`authorname`,`booktype`,`qty`,`date`) VALUES 
 (1,'Ma','1212','Anisul Haque','Novel',50,'2019-04-09'),
 (2,'Ma','1212','Anisul Haque','Novel',10,'2019-04-09'),
 (3,'sei somoy','1212','Sunil','Novel',50,'2019-04-10'),
 (4,'Nirbason','2121','Humayun Ahmed','Novel',50,'2019-04-11'),
 (5,'roudro likhe joy','2222','shamsur Rahman','Poem',50,'2019-04-11'),
 (6,'Boba Kahini','3333','Joshiuddin','Poem',50,'2019-04-11'),
 (7,'Ami Topu','4444','Muhammad Zafar Ikbal','Novel',100,'2019-04-11'),
 (8,'Borof Gola Nodi','5555','Zohir Rayhan','Novel',100,'2019-04-11'),
 (9,'Abol Tabol','Sukumar Roy','6666','Poem',50,'2019-04-11'),
 (10,'Ruposhi Bangla','Jibonando Das','7777','Poem',50,'2019-04-11'),
 (11,'Gitanjoli','Robindranath Tagore','8888','Poem',50,'2019-04-11'),
 (12,'Ekattorer Dinguli','9090','Jahanara Imam','Historical',50,'2019-04-11');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`,`role_name`) VALUES 
 (1,'Admin'),
 (2,'Librarian'),
 (3,'Reader');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `summary`
--

DROP TABLE IF EXISTS `summary`;
CREATE TABLE `summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `isbn` varchar(30) DEFAULT NULL,
  `authorname` varchar(30) DEFAULT NULL,
  `booktype` varchar(30) DEFAULT NULL,
  `qty` int(11) DEFAULT NULL,
  `issueQty` int(11) DEFAULT NULL,
  `availableQty` int(11) DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bookid` (`bookid`),
  CONSTRAINT `summary_ibfk_1` FOREIGN KEY (`bookid`) REFERENCES `purchase` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `summary`
--

/*!40000 ALTER TABLE `summary` DISABLE KEYS */;
INSERT INTO `summary` (`id`,`title`,`isbn`,`authorname`,`booktype`,`qty`,`issueQty`,`availableQty`,`bookid`) VALUES 
 (1,'Ma','1212','Anisul Haque','Novel',50,0,50,1),
 (2,'Ma','1212','Anisul Haque','Novel',10,0,10,1),
 (3,'sei somoy','1212','Sunil','Novel',50,0,50,1),
 (4,'Nirbason','2121','Humayun Ahmed','Novel',50,0,50,4),
 (5,'roudro likhe joy','2222','shamsur Rahman','Poem',50,0,50,5),
 (6,'Boba Kahini','3333','Joshiuddin','Poem',50,0,50,6),
 (7,'Ami Topu','4444','Muhammad Zafar Ikbal','Novel',100,0,100,7),
 (8,'Borof Gola Nodi','5555','Zohir Rayhan','Novel',100,0,100,8),
 (9,'Abol Tabol','Sukumar Roy','6666','Poem',50,0,50,9),
 (10,'Ruposhi Bangla','Jibonando Das','7777','Poem',50,0,50,10),
 (11,'Gitanjoli','Robindranath Tagore','8888','Poem',50,0,50,11),
 (12,'Ekattorer Dinguli','9090','Jahanara Imam','Historical',50,0,50,12);
/*!40000 ALTER TABLE `summary` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(30) DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `institute` varchar(50) DEFAULT NULL,
  `contact` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `password` (`password`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`fullname`,`userid`,`username`,`password`,`email`,`institute`,`contact`,`role_id`) VALUES 
 (1,'Sumaiya','R12','sm','1234','sm@gmail.com','Jagannath University',1234545,3),
 (4,'dfgdgfgsh','R15','ms','1233','sm@hmaol.','JahangirNagar University',34253453,3),
 (6,'Farhana','R13','FB','1543','far@gmail.com','Ibais University',1369874,3),
 (7,'Arifa','R17','Ar','2341','Arf@gmail.com','JahangirNagar University',21547896,3),
 (8,'Smrity','R20','FS','5678','sm@gmail.com','Jagannath University',18287282,3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
