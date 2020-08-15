-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: planet_food
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `cat_id` varchar(10) NOT NULL,
  `cat_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cat_id`),
  UNIQUE KEY `cat_id_UNIQUE` (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES ('C101','Pizza\'s'),('C102','Sandwich'),('C103','Burger'),('C104','Paneer'),('C105','Rice'),('C106','Chapati'),('C107','Chinese'),('C108','South Indian');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `emp_id` varchar(10) NOT NULL,
  `emp_name` varchar(45) DEFAULT NULL,
  `emp_job` varchar(45) DEFAULT NULL,
  `emp_sal` double DEFAULT NULL,
  `active` char(1) DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  UNIQUE KEY `emp_id_UNIQUE` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES ('E101','Rajshekhar','Manager',2010101,'Y'),('E102','Prashant','Waiter',500,'Y'),('E103','Saurav','Waiter',600,'Y');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_details` (
  `ord_id` varchar(10) DEFAULT NULL,
  `prod_id` varchar(10) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `cost` double DEFAULT NULL,
  KEY `fk_ord_id_idx` (`ord_id`),
  KEY `fk_prod_id_idx` (`prod_id`),
  CONSTRAINT `fk_ord_id` FOREIGN KEY (`ord_id`) REFERENCES `orders` (`ord_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_prod_id` FOREIGN KEY (`prod_id`) REFERENCES `products` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_details`
--

LOCK TABLES `order_details` WRITE;
/*!40000 ALTER TABLE `order_details` DISABLE KEYS */;
INSERT INTO `order_details` VALUES ('OD101','P103',12,1200);
/*!40000 ALTER TABLE `order_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `ord_id` varchar(10) NOT NULL,
  `ord_date` date DEFAULT NULL,
  `ord_amount` double DEFAULT NULL,
  `gst` double DEFAULT NULL,
  `gst_amount` double DEFAULT NULL,
  `grand_total` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `user_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ord_id`),
  UNIQUE KEY `ord_id_UNIQUE` (`ord_id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES ('OD101','2019-09-06',1080,5,54,1134,120,'U102');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `prod_id` varchar(10) NOT NULL,
  `prod_name` varchar(45) DEFAULT NULL,
  `cat_id` varchar(10) DEFAULT NULL,
  `prod_price` double DEFAULT NULL,
  `active` char(1) DEFAULT NULL,
  PRIMARY KEY (`prod_id`),
  UNIQUE KEY `prod_id_UNIQUE` (`prod_id`),
  KEY `fk_cat_id_idx` (`cat_id`),
  CONSTRAINT `fk_cat_id` FOREIGN KEY (`cat_id`) REFERENCES `categories` (`cat_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('P101','Veg Sandwich','C102',45,'Y'),('P102','Chees Sandwich','C102',80,'Y'),('P103','Paneer Sandwich','C102',100,'Y'),('P104','Corn Sandwich','C102',120,'Y'),('P105','Vag Burger','C103',20,'Y'),('P106','Chatpata','C102',30,'Y'),('P107','Big Belly Burger','C103',45,'Y'),('P108','Sada Roti','C106',5,'Y'),('P109','Butter Roti','C106',7,'Y'),('P110','Tandoori roti','C106',10,'Y'),('P111','Chaumin','C107',50,'Y'),('P112','Manchurian','C107',60,'Y'),('P113','Chilli Potato','C107',40,'Y'),('P114','Vag pizza','C101',100,'Y'),('P115','Non Vag','C101',200,'Y'),('P116','Matar Paneer','C104',60,'Y'),('P117','Butter Paneer Masala','C104',100,'Y'),('P118','Normal','C105',30,'Y'),('P119','Fried Rice','C105',123,'Y'),('P120','Dosa','C108',102,'Y'),('P121','Idli','C108',20,'Y');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` varchar(10) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `emp_id` varchar(10) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `user_type` varchar(45) DEFAULT NULL,
  `active` char(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `fk_emp_id_idx` (`emp_id`),
  CONSTRAINT `fk_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('U101','Rajshekhar','E101','12345','Admin','Y'),('U102','Prashant','E102','123456','Cashier','Y');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-09-06 22:43:39
