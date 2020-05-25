CREATE DATABASE  IF NOT EXISTS `moviesystem` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `moviesystem`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: moviesystem
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

DROP TABLE IF EXISTS account;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  USERNAME varchar(244) NOT NULL,
  `PASSWORD` varchar(244) NOT NULL,
  `TYPE` varchar(5) NOT NULL,
  USERID int(11) NOT NULL,
  PRIMARY KEY (USERNAME)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES account WRITE;
/*!40000 ALTER TABLE account DISABLE KEYS */;
INSERT INTO account VALUES ('Hiep','a123','admin',1),('Phuc','a123','staff',2);
/*!40000 ALTER TABLE account ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS admin;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE admin (
  ID int(11) NOT NULL,
  `NAME` varchar(244) NOT NULL,
  DOB varchar(244) NOT NULL,
  PHONE varchar(244) NOT NULL,
  ACCOUNTNAME varchar(20) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES admin WRITE;
/*!40000 ALTER TABLE admin DISABLE KEYS */;
/*!40000 ALTER TABLE admin ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extraorder`
--

DROP TABLE IF EXISTS extraorder;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE extraorder (
  EXTRAORDERID int(11) NOT NULL,
  LSTEXTRAORDER text NOT NULL,
  PRIMARY KEY (EXTRAORDERID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extraorder`
--

LOCK TABLES extraorder WRITE;
/*!40000 ALTER TABLE extraorder DISABLE KEYS */;
/*!40000 ALTER TABLE extraorder ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foodanddrink`
--

DROP TABLE IF EXISTS foodanddrink;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE foodanddrink (
  ID int(11) NOT NULL,
  `NAME` varchar(244) NOT NULL,
  PRICE double NOT NULL,
  QUANTITY int(11) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foodanddrink`
--

LOCK TABLES foodanddrink WRITE;
/*!40000 ALTER TABLE foodanddrink DISABLE KEYS */;
/*!40000 ALTER TABLE foodanddrink ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS movie;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE movie (
  ID int(11) NOT NULL,
  `NAME` varchar(244) NOT NULL,
  GENRE varchar(244) NOT NULL,
  PREMIERE varchar(244) NOT NULL,
  `TIME` varchar(244) NOT NULL,
  IMG blob NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES movie WRITE;
/*!40000 ALTER TABLE movie DISABLE KEYS */;
/*!40000 ALTER TABLE movie ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movieschedule`
--

DROP TABLE IF EXISTS movieschedule;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE movieschedule (
  ID int(11) NOT NULL,
  `SCHEDULE` varchar(244) NOT NULL,
  MOVIEID int(11) NOT NULL,
  ROOMID int(11) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movieschedule`
--

LOCK TABLES movieschedule WRITE;
/*!40000 ALTER TABLE movieschedule DISABLE KEYS */;
/*!40000 ALTER TABLE movieschedule ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS orders;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE orders (
  ORDERID int(11) NOT NULL,
  NUMOFTICKET int(11) NOT NULL,
  TOTALPRICE double NOT NULL,
  MOVIESCHEDULEID int(11) NOT NULL,
  EXTRAORDERID int(11) NOT NULL,
  PRIMARY KEY (ORDERID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES orders WRITE;
/*!40000 ALTER TABLE orders DISABLE KEYS */;
/*!40000 ALTER TABLE orders ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS room;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE room (
  ROOMID int(11) NOT NULL,
  ROOMNAME varchar(244) NOT NULL,
  SEATS text,
  PRIMARY KEY (ROOMID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES room WRITE;
/*!40000 ALTER TABLE room DISABLE KEYS */;
/*!40000 ALTER TABLE room ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS staff;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE staff (
  ID int(11) NOT NULL,
  `NAME` varchar(244) NOT NULL,
  DOB varchar(244) NOT NULL,
  PHONE varchar(244) NOT NULL,
  ACCOUNTNAME varchar(20) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES staff WRITE;
/*!40000 ALTER TABLE staff DISABLE KEYS */;
/*!40000 ALTER TABLE staff ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-10 21:41:18
