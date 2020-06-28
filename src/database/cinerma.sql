-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cinerma
-- ------------------------------------------------------
-- Server version	5.7.29-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(255) COLLATE utf8_bin NOT NULL,
  `passoword` varchar(255) COLLATE utf8_bin NOT NULL,
  `type` varchar(255) COLLATE utf8_bin NOT NULL,
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('hieptv','1234','staff'),('phuc','1234','admin'),('toan','1234','staff');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foodanddrink`
--

DROP TABLE IF EXISTS `foodanddrink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foodanddrink` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `price` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foodanddrink`
--

LOCK TABLES `foodanddrink` WRITE;
/*!40000 ALTER TABLE `foodanddrink` DISABLE KEYS */;
INSERT INTO `foodanddrink` VALUES (1,'Popcorn','2'),(2,'Coca cola','1'),(3,'Pepsi','1'),(4,'Hot dog','2'),(5,'Hamburger','3');
/*!40000 ALTER TABLE `foodanddrink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foodanddrink_order`
--

DROP TABLE IF EXISTS `foodanddrink_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foodanddrink_order` (
  `Orderid` int(10) NOT NULL,
  `FoodAndDrinkid` int(10) NOT NULL,
  `amount` int(10) NOT NULL,
  PRIMARY KEY (`Orderid`,`FoodAndDrinkid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foodanddrink_order`
--

LOCK TABLES `foodanddrink_order` WRITE;
/*!40000 ALTER TABLE `foodanddrink_order` DISABLE KEYS */;
INSERT INTO `foodanddrink_order` VALUES (1,1,2),(1,2,1),(2,1,1),(2,5,1),(3,4,1),(3,5,1),(4,3,1),(4,4,1),(4,5,1),(7,5,1);
/*!40000 ALTER TABLE `foodanddrink_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `genre` varchar(255) COLLATE utf8_bin NOT NULL,
  `durationTime` varchar(255) COLLATE utf8_bin NOT NULL,
  `thumbnail` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'Avengers 4: Endgame (2019)','Science Fiction Films, Action Films','181 minutes','src/img/avengerendgame.jpg'),(2,'Joker','Drama Films','121 minutes','src/img/joker.jpg'),(3,'Parasite','Drama Films','131 minutes','src/img/parasite.jpg'),(4,'John Wick: Chapter 3 - Parabellum (2019)','Action Films','131 minutes','src/img/johnwick3.jpg'),(5,'Spider-Man: Far from Home','Action Films','129 minutes','src/img/spiderman.jpg');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `numberTicket` int(10) NOT NULL,
  `totalPrice` double NOT NULL,
  `Movieid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKOrder630415` (`Movieid`),
  CONSTRAINT `FKOrder630415` FOREIGN KEY (`Movieid`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,2,5,1),(2,1,3,2),(9,1,3,1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `orderedSeat` varchar(255) COLLATE utf8_bin NOT NULL,
  `Scheduleid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKRoom687810` (`Scheduleid`),
  CONSTRAINT `FKRoom687810` FOREIGN KEY (`Scheduleid`) REFERENCES `schedule` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'101','A-6 A-5 B-5 A-4 ',1),(2,'102','A-6 A-5',2),(3,'101','A-6 A-5',3),(4,'101','A-6 A-5',4),(5,'102','A-6 A-5',5),(6,'102','A-6 A-5',6),(7,'103','A-6 A-5',1);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `time` varchar(255) COLLATE utf8_bin NOT NULL,
  `Movieid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKSchedule361548` (`Movieid`),
  CONSTRAINT `FKSchedule361548` FOREIGN KEY (`Movieid`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'9h-12h30',1),(2,'14h-15h30',1),(3,'19h-21h',3),(4,'20h-22h30',2),(5,'15h-17h30',4),(6,'8h-10h30',5);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-28  8:14:57
