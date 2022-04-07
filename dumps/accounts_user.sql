-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: accounts
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(255) NOT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `e_mail` varchar(255) NOT NULL,
  `joined_at` datetime(6) NOT NULL,
  `password` varchar(255) NOT NULL,
  `profile_picture` varchar(255) DEFAULT NULL,
  `role` int NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_5awx5dcb9xdv5m1bl38bmoke0` (`e_mail`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('0','2000-01-01 00:00:00.000000','dummy.user@gmail.com','2022-03-27 04:20:00.000000','dummy',NULL,0,'user'),('1fb583b7-8cef-453f-a0dc-dc79799df8b7',NULL,'cont.fain@gmail.com','2022-04-06 00:21:43.225788','contfain',NULL,0,'ContMisto69'),('3','2000-01-01 00:00:00.000000','dummy.mod@gmail.com','2022-03-27 04:20:00.000000','dummy',NULL,3,'mod'),('32a23475-c188-4c5c-8b0a-25c6c6131f9a',NULL,'s.a@mearga.com','2022-04-07 17:12:00.877288','parola',NULL,0,'trebuie'),('56e36448-ad5b-11ec-87da-089798e5845b','2000-02-17 00:00:00.000000','iam.happy@gmail.com','2022-03-27 04:20:00.000000','happy',NULL,0,'happiness'),('8892e3b5-3ca3-4471-8c11-95bc4e117f71',NULL,'de.proba@gmail.com','2022-04-07 17:09:42.337750','parola',NULL,0,'altcont'),('96458685-2da2-433f-aa88-62f1433c3d24',NULL,'co.nt@gmail.com','2022-04-07 17:08:12.760769','parola',NULL,0,'contInteresant'),('b8290e1b-aea8-49d6-a438-ae8ff454b9d6',NULL,'cot@gmail.com','2022-04-07 17:10:58.862883','parola',NULL,0,'unaltcont6');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-07 17:41:19
