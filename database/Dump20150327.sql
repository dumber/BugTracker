CREATE DATABASE  IF NOT EXISTS `bugtrack` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bugtrack`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bugtrack
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `detection_phases`
--

DROP TABLE IF EXISTS `detection_phases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detection_phases` (
  `dp_id` int(11) NOT NULL AUTO_INCREMENT,
  `phases` varchar(38) NOT NULL,
  PRIMARY KEY (`dp_id`),
  UNIQUE KEY `phases_UNIQUE` (`phases`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detection_phases`
--

LOCK TABLES `detection_phases` WRITE;
/*!40000 ALTER TABLE `detection_phases` DISABLE KEYS */;
INSERT INTO `detection_phases` VALUES (2,'Code Inspection'),(5,'Requirement Based Functional Testing'),(4,'Software Integration Testing'),(3,'Software Unit Testing'),(1,'Specification'),(7,'System Acceptance Testing'),(6,'System Integration Testing');
/*!40000 ALTER TABLE `detection_phases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `priorities`
--

DROP TABLE IF EXISTS `priorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `priorities` (
  `pr_id` int(11) NOT NULL AUTO_INCREMENT,
  `priority` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`pr_id`),
  UNIQUE KEY `priority_UNIQUE` (`priority`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `priorities`
--

LOCK TABLES `priorities` WRITE;
/*!40000 ALTER TABLE `priorities` DISABLE KEYS */;
INSERT INTO `priorities` VALUES (3,'High'),(1,'Low'),(2,'Medium');
/*!40000 ALTER TABLE `priorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_versions`
--

DROP TABLE IF EXISTS `project_versions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_versions` (
  `pv_id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`pv_id`),
  UNIQUE KEY `id_UNIQUE` (`pv_id`),
  UNIQUE KEY `version_UNIQUE` (`version`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_versions`
--

LOCK TABLES `project_versions` WRITE;
/*!40000 ALTER TABLE `project_versions` DISABLE KEYS */;
INSERT INTO `project_versions` VALUES (1,'0.7a'),(2,'0.8b'),(4,'0.9.1b'),(5,'0.9.2b'),(3,'0.9b'),(6,'1.0'),(7,'1.0.1'),(8,'1.0.2'),(9,'1.1.0'),(10,'1.1.1'),(11,'1.2.0'),(12,'1.2.1'),(13,'1.2.2'),(14,'1.2.3'),(15,'1.2.4'),(16,'2.0'),(17,'2.1'),(18,'2.2'),(19,'2.3'),(20,'2.4'),(21,'2.5');
/*!40000 ALTER TABLE `project_versions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `p_id_UNIQUE` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (3,'Accounting Assistant application'),(2,'U400'),(1,'U500');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `severities`
--

DROP TABLE IF EXISTS `severities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `severities` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `severity` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  UNIQUE KEY `severity_UNIQUE` (`severity`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `severities`
--

LOCK TABLES `severities` WRITE;
/*!40000 ALTER TABLE `severities` DISABLE KEYS */;
INSERT INTO `severities` VALUES (4,'Blocking'),(1,'Bypassing'),(3,'Major'),(2,'Minor');
/*!40000 ALTER TABLE `severities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket_states`
--

DROP TABLE IF EXISTS `ticket_states`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket_states` (
  `ts_id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(18) DEFAULT 'Submited/New',
  PRIMARY KEY (`ts_id`),
  UNIQUE KEY `state_UNIQUE` (`state`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket_states`
--

LOCK TABLES `ticket_states` WRITE;
/*!40000 ALTER TABLE `ticket_states` DISABLE KEYS */;
INSERT INTO `ticket_states` VALUES (2,'Analysed'),(5,'Closed'),(3,'Realized'),(1,'Submited/New'),(4,'Validated'),(6,'Validation failed');
/*!40000 ALTER TABLE `ticket_states` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tickets` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_id` varchar(16) DEFAULT 'alpha000001',
  `project_id` int(11) NOT NULL,
  `submission_version` varchar(12) NOT NULL,
  `headline` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `scheduled_version` varchar(12) NOT NULL,
  `submitter_user_id` int(11) NOT NULL,
  `submission_date` date NOT NULL,
  `detection_phase` varchar(38) DEFAULT NULL,
  `severity` varchar(9) NOT NULL,
  `priority` varchar(6) NOT NULL,
  `estimated_wl` int(11) DEFAULT NULL,
  `workload` int(11) DEFAULT NULL,
  `state` varchar(18) DEFAULT NULL,
  `linked_ticket` varchar(16) DEFAULT NULL,
  `linked_headline` varchar(45) DEFAULT NULL,
  `analyser_user_id` int(11) DEFAULT NULL,
  `proposed_change` text,
  `impacted_version` varchar(12) DEFAULT NULL,
  `analysis_date` date DEFAULT NULL,
  `realiser_user_id` int(11) DEFAULT NULL,
  `realised_items` text,
  `realised_version` varchar(12) DEFAULT NULL,
  `realisation_date` date DEFAULT NULL,
  `validator_user_id` int(11) DEFAULT NULL,
  `validator_comments` text,
  `validated_version` varchar(12) DEFAULT NULL,
  `validation_date` date DEFAULT NULL,
  `closure_date` date DEFAULT NULL,
  PRIMARY KEY (`t_id`),
  UNIQUE KEY `ticket_id_UNIQUE` (`ticket_id`),
  KEY `fk_project_id_idx` (`project_id`),
  KEY `fk_severity_idx` (`severity`),
  KEY `fk_priority_idx` (`priority`),
  KEY `fk_state_idx` (`state`),
  KEY `fk_submitter_idx` (`submitter_user_id`),
  KEY `fk_analyser_idx` (`analyser_user_id`),
  KEY `fk_realiser_idx` (`realiser_user_id`),
  KEY `fk_validator_idx` (`validator_user_id`),
  KEY `fk_phase_idx` (`detection_phase`),
  KEY `fk_detect_version_idx` (`submission_version`,`impacted_version`),
  KEY `fk_scheduled_version_idx` (`scheduled_version`),
  KEY `fk_impacted_version_idx` (`impacted_version`),
  KEY `fk_realised_version_idx` (`realised_version`),
  KEY `fk_validated_version_idx` (`validated_version`),
  CONSTRAINT `fk_analyser` FOREIGN KEY (`analyser_user_id`) REFERENCES `users` (`u_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_detection_version` FOREIGN KEY (`submission_version`) REFERENCES `project_versions` (`version`) ON UPDATE CASCADE,
  CONSTRAINT `fk_impacted_version` FOREIGN KEY (`impacted_version`) REFERENCES `project_versions` (`version`) ON UPDATE CASCADE,
  CONSTRAINT `fk_phase` FOREIGN KEY (`detection_phase`) REFERENCES `detection_phases` (`phases`) ON UPDATE CASCADE,
  CONSTRAINT `fk_priority` FOREIGN KEY (`priority`) REFERENCES `priorities` (`priority`) ON UPDATE CASCADE,
  CONSTRAINT `fk_project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`p_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_realised_version` FOREIGN KEY (`realised_version`) REFERENCES `project_versions` (`version`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_realiser` FOREIGN KEY (`realiser_user_id`) REFERENCES `users` (`u_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_scheduled_version` FOREIGN KEY (`scheduled_version`) REFERENCES `project_versions` (`version`) ON UPDATE CASCADE,
  CONSTRAINT `fk_severity` FOREIGN KEY (`severity`) REFERENCES `severities` (`severity`) ON UPDATE CASCADE,
  CONSTRAINT `fk_state` FOREIGN KEY (`state`) REFERENCES `ticket_states` (`state`) ON UPDATE CASCADE,
  CONSTRAINT `fk_submitter` FOREIGN KEY (`submitter_user_id`) REFERENCES `users` (`u_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_validated_version` FOREIGN KEY (`validated_version`) REFERENCES `project_versions` (`version`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_validator` FOREIGN KEY (`validator_user_id`) REFERENCES `users` (`u_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,'alpha0000001',1,'1.0','RSV : Specification fault, missing variable','1. The SwRS-101 states that the component calculates the time constraint, but in SwRS-102 a contradicting statement can be found.\n2. T_Time is not defined','1.0',3,'2015-03-12','Specification','Minor','Medium',2,NULL,'Submited/New',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_types`
--

DROP TABLE IF EXISTS `user_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_types` (
  `ut_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` varchar(12) NOT NULL,
  PRIMARY KEY (`ut_id`),
  UNIQUE KEY `user_type_UNIQUE` (`user_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_types`
--

LOCK TABLES `user_types` WRITE;
/*!40000 ALTER TABLE `user_types` DISABLE KEYS */;
INSERT INTO `user_types` VALUES (1,'admin'),(2,'developer'),(3,'validator');
/*!40000 ALTER TABLE `user_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL DEFAULT 'user',
  `password` varchar(45) NOT NULL DEFAULT 'pass',
  `type` varchar(12) NOT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_id_UNIQUE` (`u_id`),
  KEY `fk_usr_type_idx` (`type`),
  CONSTRAINT `fk_usr_type` FOREIGN KEY (`type`) REFERENCES `user_types` (`user_type`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ltamas','asdf','admin'),(2,'abela','qwer','developer'),(3,'baladar','zxcv','validator');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bugtrack'
--

--
-- Dumping routines for database 'bugtrack'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-27 21:44:25
