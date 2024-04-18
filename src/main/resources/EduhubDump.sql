-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: group11_eduhubdb
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `article_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `published_date` date DEFAULT NULL,
  `tags` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,2,'Top 10 Programming Languages of 2023','Explore the most popular programming languages of 2023.','2023-01-05','programming, languages'),(2,4,'Cybersecurity Trends in 2023','Discover the latest trends and challenges in cybersecurity for 2023.','2023-02-10','cybersecurity, trends'),(3,6,'Data Science Techniques for Beginners','Learn essential data science techniques for beginners.','2023-03-20','data science, techniques'),(4,8,'Cloud Computing Best Practices','Explore best practices for implementing cloud computing solutions.','2023-04-15','cloud computing, best practices'),(5,10,'Blockchain Applications in Finance','Discover how blockchain technology is transforming the finance industry.','2023-05-25','blockchain, finance'),(6,1,'Web Development Frameworks Comparison','Compare popular web development frameworks for building modern web applications.','2023-06-30','web development, frameworks'),(7,3,'AI and Machine Learning in Healthcare','Explore the applications of AI and machine learning in improving healthcare.','2023-07-10','AI, machine learning, healthcare'),(8,5,'The Future of Mobile App Development','Predictions and insights into the future of mobile app development.','2023-08-20','mobile apps, development'),(9,7,'Agile Project Management Principles','Key principles and strategies for agile project management.','2023-09-05','agile, project management'),(10,9,'Big Data Analytics for Business Growth','Harnessing big data analytics for driving business growth.','2023-10-10','big data, analytics');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificate` (
  `internal_certificate_id` int NOT NULL AUTO_INCREMENT,
  `external_certificate_id` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`internal_certificate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
INSERT INTO `certificate` VALUES (1,'CERT12345',1,'John Doe',1,'Introduction to Programming'),(2,'CERT23456',3,'Alice Johnson',5,'Machine Learning Basics'),(3,'CERT34567',5,'Eva Green',9,'Software Engineering Principles'),(4,'CERT45678',7,'Sophia Martinez',4,'Python for Data Analysis'),(5,'CERT56789',9,'Olivia Anderson',6,'Cybersecurity Fundamentals'),(6,'CERT67890',2,'Jane Smith',3,'Data Science Essentials'),(7,'CERT78901',4,'Bob Brown',2,'Web Development Fundamentals'),(8,'CERT89012',6,'Michael Lee',8,'Cloud Computing Essentials'),(9,'CERT90123',8,'David Wilson',7,'Mobile App Development'),(10,'CERT01234',10,'William Taylor',10,'Blockchain Fundamentals');
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `course_price` float(8,4) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Introduction to Programming','Learn the basics of programming in this introductory course.',2,49.9900,'https://example.com/course1.jpg','Beginner level'),(2,'Web Development Fundamentals','Explore the essentials of web development with HTML, CSS, and JavaScript.',5,69.9900,'https://example.com/course2.jpg','Intermediate level'),(3,'Data Science Essentials','Discover the fundamentals of data science and analysis techniques.',7,89.9900,'https://example.com/course3.jpg','Advanced level'),(4,'Python for Data Analysis','Master Python programming for data analysis and manipulation.',2,79.9900,'https://example.com/course4.jpg','Intermediate level'),(5,'Machine Learning Basics','Learn the basics of machine learning algorithms and techniques.',5,99.9900,'https://example.com/course5.jpg','Advanced level'),(6,'Cybersecurity Fundamentals','Get started with cybersecurity principles and best practices.',7,59.9900,'https://example.com/course6.jpg','Intermediate level'),(7,'Mobile App Development','Build mobile apps using frameworks like React Native and Flutter.',10,129.9900,'https://example.com/course7.jpg','Advanced level'),(8,'Cloud Computing Essentials','Explore cloud computing concepts and platforms like AWS and Azure.',8,79.9900,'https://example.com/course8.jpg','Intermediate level'),(9,'Software Engineering Principles','Understand software engineering methodologies and practices.',6,69.9900,'https://example.com/course9.jpg','Intermediate level'),(10,'Blockchain Fundamentals','Learn about blockchain technology and its applications.',10,89.9900,'https://example.com/course10.jpg','Advanced level');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eduhub_user`
--

DROP TABLE IF EXISTS `eduhub_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eduhub_user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eduhub_user`
--

LOCK TABLES `eduhub_user` WRITE;
/*!40000 ALTER TABLE `eduhub_user` DISABLE KEYS */;
INSERT INTO `eduhub_user` VALUES (1,'user1@example.com','John Doe','student'),(2,'user2@example.com','Jane Smith','instructor'),(3,'user3@example.com','Alice Johnson','student'),(4,'user4@example.com','Bob Brown','student'),(5,'user5@example.com','Eva Green','instructor'),(6,'user6@example.com','Michael Lee','student'),(7,'user7@example.com','Sophia Martinez','instructor'),(8,'user8@example.com','David Wilson','student'),(9,'user9@example.com','Olivia Anderson','student'),(10,'user10@example.com','William Taylor','instructor');
/*!40000 ALTER TABLE `eduhub_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enrollment`
--

DROP TABLE IF EXISTS `enrollment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enrollment` (
  `enrollment_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `enrollment_date` date DEFAULT NULL,
  `completion_date` date DEFAULT NULL,
  `is_complete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`enrollment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enrollment`
--

LOCK TABLES `enrollment` WRITE;
/*!40000 ALTER TABLE `enrollment` DISABLE KEYS */;
INSERT INTO `enrollment` VALUES (1,1,1,'2023-01-15',NULL,0),(2,2,3,'2023-02-20',NULL,0),(3,3,5,'2023-03-10',NULL,0),(4,4,7,'2023-04-05',NULL,0),(5,5,9,'2023-05-12',NULL,0),(6,6,2,'2023-06-18',NULL,0),(7,7,4,'2023-07-22',NULL,0),(8,8,6,'2023-08-30',NULL,0),(9,9,8,'2023-09-10',NULL,0),(10,10,10,'2023-10-05',NULL,0);
/*!40000 ALTER TABLE `enrollment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lesson` (
  `lesson_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`lesson_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,'Getting Started with Python','Introduction to Python programming language.',4,'Python Basics','https://example.com/lesson1.jpg'),(2,'HTML Fundamentals','Learn the basics of HTML for web development.',2,'HTML Basics','https://example.com/lesson2.jpg'),(3,'Data Visualization Techniques','Explore techniques for visualizing data.',3,'Data Visualization','https://example.com/lesson3.jpg'),(4,'Introduction to Machine Learning','Basic concepts and algorithms in machine learning.',5,'ML Basics','https://example.com/lesson4.jpg'),(5,'Network Security Fundamentals','Basics of network security and protocols.',6,'Network Security','https://example.com/lesson5.jpg'),(6,'React Native Basics','Introduction to building mobile apps with React Native.',7,'React Native','https://example.com/lesson6.jpg'),(7,'AWS Cloud Services','Overview of AWS cloud computing services.',8,'AWS Basics','https://example.com/lesson7.jpg'),(8,'Agile Software Development','Principles and practices of agile software development.',9,'Agile Basics','https://example.com/lesson8.jpg'),(9,'Blockchain Technology Overview','Fundamentals of blockchain technology.',10,'Blockchain Basics','https://example.com/lesson9.jpg'),(10,'Big Data Analytics','Introduction to big data analytics tools and techniques.',3,'Big Data Basics','https://example.com/lesson10.jpg');
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question_number` int DEFAULT NULL,
  `quiz_id` int DEFAULT NULL,
  `question_description` varchar(255) DEFAULT NULL,
  `option1` varchar(255) DEFAULT NULL,
  `option2` varchar(255) DEFAULT NULL,
  `option3` varchar(255) DEFAULT NULL,
  `option4` varchar(255) DEFAULT NULL,
  `correct_answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,1,1,'What is the output of print(2 + 3 * 4)?','14','20','24','26','14'),(2,2,1,'Which of the following is not a Python data type?','int','string','boolean','array','array'),(3,3,1,'What is the result of 7 % 3?','2','3','1','4','1'),(4,1,2,'What does HTML stand for?','Hyper Text Markup Language','Hyperlinks and Text Markup Language','Home Tool Markup Language','High Text Markup Language','Hyper Text Markup Language'),(5,2,2,'Which tag is used to define an unordered list?','<ul>','<ol>','<li>','<ul><li>','<ul>'),(6,3,2,'What does CSS stand for?','Creative Style Sheets','Cascading Style Sheets','Computer Style Sheets','Colorful Style Sheets','Cascading Style Sheets'),(7,1,3,'What type of chart is best suited for showing trends over time?','Pie chart','Bar chart','Line chart','Scatter plot','Line chart'),(8,2,3,'Which library is commonly used for data visualization in Python?','Pandas','Matplotlib','Numpy','Scikit-learn','Matplotlib'),(9,3,3,'What is the primary purpose of data visualization?','To confuse viewers','To present data in a visually appealing way','To hide data','To manipulate data','To present data in a visually appealing way'),(10,1,4,'What is the objective of supervised learning?','To find hidden patterns in data','To classify data into predefined categories','To analyze unstructured data','To predict future outcomes','To classify data into predefined categories'),(11,2,4,'Which algorithm is commonly used for linear regression?','Decision Trees','Support Vector Machines','K-Nearest Neighbors','Linear Regression','Linear Regression'),(12,3,4,'What is overfitting in machine learning?','When a model performs well on training data but poorly on test data','When a model performs poorly on training data and test data','When a model fits the training data too closely and performs poorly on new data','When a model has too many features','When a model fits the training data too closely and performs poorly on new data');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz` (
  `quiz_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `lesson_id` int DEFAULT NULL,
  PRIMARY KEY (`quiz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,'Python Quiz',1),(2,'HTML Quiz',2),(3,'Data Visualization Quiz',3),(4,'Machine Learning Quiz',4),(5,'Network Security Quiz',5),(6,'React Native Quiz',6),(7,'AWS Quiz',7),(8,'Agile Quiz',8),(9,'Blockchain Quiz',9),(10,'Big Data Quiz',10);
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `submission`
--

DROP TABLE IF EXISTS `submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `submission` (
  `submission_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `quiz_id` int DEFAULT NULL,
  `score` float DEFAULT NULL,
  PRIMARY KEY (`submission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `submission`
--

LOCK TABLES `submission` WRITE;
/*!40000 ALTER TABLE `submission` DISABLE KEYS */;
INSERT INTO `submission` VALUES (1,1,1,90),(2,2,3,85),(3,3,5,95),(4,4,7,75),(5,5,9,80),(6,6,2,92),(7,7,4,88),(8,8,6,96),(9,9,8,84),(10,10,10,90);
/*!40000 ALTER TABLE `submission` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-17 20:19:54
