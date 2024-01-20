-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: biljartline_identity
-- ------------------------------------------------------
-- Server version	5.5.5-10.11.5-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `biljartline_user`
--

DROP TABLE IF EXISTS `biljartline_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `biljartline_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biljartline_user`
--

LOCK TABLES `biljartline_user` WRITE;
/*!40000 ALTER TABLE `biljartline_user` DISABLE KEYS */;
INSERT INTO `biljartline_user` VALUES (1,'MyFirstUser','Test123///','USER'),(2,'test1','{bcrypt}$2a$10$e5v9dX9UmLmfhSWgvDFfZei7HF9WO8iLDKcbgSUH829MOrRkYYrCe','USER'),(3,'test12','{bcrypt}$2a$10$GlW.7fZxPmrykA5jGoSZseDOlMVtsRk.FcLsNke3tZMddmzTWJO5C','USER'),(4,'test123','{bcrypt}$2a$10$nnIO6AhUzb.2LIno10O9xOdeg461pQM0adW93sFXMzx23y8U3LhRa','USER'),(5,'test1233','{bcrypt}$2a$10$eFq1Q5qjVRhMmanmdtLniu/IDHS5MkgXu6Syzm3heNk5NoZEtT8Su','USER'),(6,'test12233','{bcrypt}$2a$10$lZIpu.TYKcEbs2xtO8Lds.J1D8f0SJCv0EpeQSPVLWRt4dbY8UpYu','USER'),(7,'test122333','{bcrypt}$2a$10$EF4baU5P/tO0wDwZXsFRv.jQI6.msXklFvL8WdkYCPEB36qu7WLwO','USER'),(8,'test5','{bcrypt}$2a$10$FC9kGPuOd1gHJyyp7jf9A.6mML.0GmJwX9YWzudz6RNyD2xyhv66W','USER'),(9,'test6','{bcrypt}$2a$10$DoSLwo/nGh68HmhDC/tYNuHeRC3v2k3Y.q6.ncb9PfwpNHhDwbA66','USER'),(10,'test7','{bcrypt}$2a$10$kb4G6MK0sRXnVIUJG/njfeR9hjZfMFn4Sn6hnvRlqGML5DxOT0Zju','USER'),(11,'test8','{bcrypt}$2a$10$MhO2ixJUPpgT4FVSjeTReuIFM2.AcLlXofqmY.w2vt6N7uaZG0o8m','USER'),(12,'test9','{bcrypt}$2a$10$sENSqgTAjtQ1wy6NC09HKuXa7zpnFs1m1Zb8STvpXtejGGCE8u9na','USER'),(13,'admin','{bcrypt}$2a$10$9vZK9p6WtM86NA0SXq4yUuZ/VY8xCyNInaziFTFpHf50LfRHKddHO','ADMIN'),(14,'BOYSYS','{bcrypt}$2a$10$uvLdu8siEXKV3ZvXJA4kouTNhMmMun6xA0/EUtpwbrDHOWTCemkzu','USER');
/*!40000 ALTER TABLE `biljartline_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'biljartline_identity'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-19 13:48:56
