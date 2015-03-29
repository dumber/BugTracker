-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bugtrack
-- ------------------------------------------------------
-- Server version	5.6.22-log
--
-- Table structure and test data for BugTracker database.
--
-- After creating the tables and test data with MySQL Workbench this dump file was generated.
--

--
-- Table structure for table `actions`
--
DROP TABLE IF EXISTS `actions`;
CREATE TABLE `actions` (
  `a_id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `action` varchar(30) NOT NULL,
  PRIMARY KEY (`a_id`),
  UNIQUE KEY `a_id_UNIQUE` (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `actions`
--
LOCK TABLES `actions` WRITE;
INSERT INTO `actions` VALUES (1,'Submit'),(2,'Modify'),(3,'Record'),(4,'Assign'),(5,'Analyse'),(6,'Realise'),(7,'Validate'),(8,'Fail'),(9,'Reject'),(10,'Cancel'),(11,'Postpone'),(12,'Close');
UNLOCK TABLES;

--
-- Table structure for table `detection_phases`
--
DROP TABLE IF EXISTS `detection_phases`;
CREATE TABLE `detection_phases` (
  `dp_id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `phase_name` varchar(100) NOT NULL,
  PRIMARY KEY (`dp_id`),
  UNIQUE KEY `dp_id_UNIQUE` (`dp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `detection_phases`
--
LOCK TABLES `detection_phases` WRITE;
INSERT INTO `detection_phases` VALUES (1,'Specification'),(2,'Code Inspection'),(3,'Software Unit Testing'),(4,'Software Integration Testing'),(5,'Requirement Based Functional Testing'),(6,'System Integration Testing'),(7,'System Acceptance Testing'),(8,'N/A');
UNLOCK TABLES;

--
-- Table structure for table `priorities`
--
DROP TABLE IF EXISTS `priorities`;
CREATE TABLE `priorities` (
  `pr_id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `priority` varchar(20) NOT NULL,
  PRIMARY KEY (`pr_id`),
  UNIQUE KEY `pr_id_UNIQUE` (`pr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
--
-- Dumping data for table `priorities`
--

LOCK TABLES `priorities` WRITE;
INSERT INTO `priorities` VALUES (1,'Very low'),(2,'Low'),(3,'Medium'),(4,'High'),(5,'Very high');
UNLOCK TABLES;

--
-- Table structure for table `project_users`
--
DROP TABLE IF EXISTS `project_users`;
CREATE TABLE `project_users` (
  `pu_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `project_id` int(6) unsigned NOT NULL,
  `user_id` int(7) unsigned NOT NULL,
  PRIMARY KEY (`pu_id`),
  UNIQUE KEY `pu_id_UNIQUE` (`pu_id`),
  KEY `fk_project_id_idx` (`project_id`),
  KEY `fk_user_id_idx` (`user_id`),
  CONSTRAINT `fk_project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`p_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`u_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `project_users`
--
LOCK TABLES `project_users` WRITE;
INSERT INTO `project_users` VALUES (1,1,2),(2,1,3),(3,1,4);
UNLOCK TABLES;

--
-- Table structure for table `project_versions`
--
DROP TABLE IF EXISTS `project_versions`;
CREATE TABLE `project_versions` (
  `pv_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `version` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`pv_id`),
  UNIQUE KEY `id_UNIQUE` (`pv_id`),
  UNIQUE KEY `version_UNIQUE` (`version`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `project_versions`
--
LOCK TABLES `project_versions` WRITE;
INSERT INTO `project_versions` VALUES (1,'0.7a'),(2,'0.8b'),(4,'0.9.1b'),(5,'0.9.2b'),(3,'0.9b'),(6,'1.0'),(7,'1.0.1'),(8,'1.0.2'),(9,'1.1.0'),(10,'1.1.1'),(11,'1.2.0'),(12,'1.2.1'),(13,'1.2.2'),(14,'1.2.3'),(15,'1.2.4'),(16,'2.0'),(17,'2.1'),(18,'2.2'),(19,'2.3'),(20,'2.4'),(21,'2.5');
UNLOCK TABLES;

--
-- Table structure for table `projects`
--
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `p_id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) NOT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `p_id_UNIQUE` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `projects`
--
LOCK TABLES `projects` WRITE;
INSERT INTO `projects` VALUES (1,'U500'),(2,'U400'),(3,'Accounting Assistant application');
UNLOCK TABLES;

--
-- Table structure for table `severities`
--
DROP TABLE IF EXISTS `severities`;
CREATE TABLE `severities` (
  `s_id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `severity` varchar(20) NOT NULL,
  PRIMARY KEY (`s_id`),
  UNIQUE KEY `s_id_UNIQUE` (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `severities`
--
LOCK TABLES `severities` WRITE;
INSERT INTO `severities` VALUES (1,'Bypassing'),(2,'Minor'),(3,'Major'),(4,'Blocking');
UNLOCK TABLES;

--
-- Table structure for table `ticket_analyses`
--
DROP TABLE IF EXISTS `ticket_analyses`;
CREATE TABLE `ticket_analyses` (
  `ta_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ta_ticket_id` int(11) unsigned NOT NULL,
  `proposed_change` text,
  `impacted_ver_id` int(4) unsigned DEFAULT NULL,
  `analysis_date` datetime DEFAULT NULL,
  `analyser_user_id` int(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`ta_id`),
  UNIQUE KEY `ta_id_UNIQUE` (`ta_id`),
  UNIQUE KEY `ta_ticket_id_UNIQUE` (`ta_ticket_id`),
  KEY `fk_ta_ticket_id_idx` (`ta_ticket_id`),
  KEY `fk_impacted_ver_id_idx` (`impacted_ver_id`),
  KEY `fk_analyser_user_id_idx` (`analyser_user_id`),
  CONSTRAINT `fk_analyser_user_id` FOREIGN KEY (`analyser_user_id`) REFERENCES `users` (`u_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_impacted_ver_id` FOREIGN KEY (`impacted_ver_id`) REFERENCES `project_versions` (`pv_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_ta_ticket_id` FOREIGN KEY (`ta_ticket_id`) REFERENCES `tickets` (`t_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket_analyses`
--
LOCK TABLES `ticket_analyses` WRITE;
INSERT INTO `ticket_analyses` VALUES (1,1,NULL,NULL,NULL,NULL);
UNLOCK TABLES;

--
-- Table structure for table `ticket_histories`
--
DROP TABLE IF EXISTS `ticket_histories`;
CREATE TABLE `ticket_histories` (
  `th_id` int(13) unsigned NOT NULL AUTO_INCREMENT,
  `th_ticket_id` int(11) unsigned NOT NULL,
  `modifier_user_id` int(7) unsigned NOT NULL,
  `old_state_id` int(2) unsigned NOT NULL,
  `new_state_id` int(2) unsigned NOT NULL,
  `action_id` int(2) unsigned NOT NULL,
  `modification_date` datetime NOT NULL,
  PRIMARY KEY (`th_id`),
  UNIQUE KEY `th_id_UNIQUE` (`th_id`),
  KEY `fk_th_ticket_id_idx` (`th_ticket_id`),
  KEY `fk_old_state_id_idx` (`old_state_id`),
  KEY `fk_new_state_id_idx` (`new_state_id`),
  KEY `fk_action_id_idx` (`action_id`),
  KEY `fk_modifier_user_id_idx` (`modifier_user_id`),
  CONSTRAINT `fk_action_id` FOREIGN KEY (`action_id`) REFERENCES `actions` (`a_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_modifier_user_id` FOREIGN KEY (`modifier_user_id`) REFERENCES `users` (`u_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_new_state_id` FOREIGN KEY (`new_state_id`) REFERENCES `ticket_states` (`ts_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_old_state_id` FOREIGN KEY (`old_state_id`) REFERENCES `ticket_states` (`ts_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_th_ticket_id` FOREIGN KEY (`th_ticket_id`) REFERENCES `tickets` (`t_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket_histories`
--
LOCK TABLES `ticket_histories` WRITE;
INSERT INTO `ticket_histories` VALUES (1,1,4,11,1,1,'2015-03-29 17:56:07'),(2,1,4,1,1,2,'2015-03-29 18:00:29');
UNLOCK TABLES;

--
-- Table structure for table `ticket_realisations`
--
DROP TABLE IF EXISTS `ticket_realisations`;
CREATE TABLE `ticket_realisations` (
  `tr_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tr_ticket_id` int(11) unsigned NOT NULL,
  `realised_items` text,
  `realised_ver_id` int(4) unsigned DEFAULT NULL,
  `realisation_date` datetime DEFAULT NULL,
  `realiser_user_id` int(7) unsigned DEFAULT NULL,
  PRIMARY KEY (`tr_id`),
  UNIQUE KEY `tr_id_UNIQUE` (`tr_id`),
  UNIQUE KEY `tr_ticket_id_UNIQUE` (`tr_ticket_id`),
  KEY `fk_tr_ticket_id_idx` (`tr_ticket_id`),
  KEY `fk_realised_ver_id_idx` (`realised_ver_id`),
  KEY `fk_realiser_user_id_idx` (`realiser_user_id`),
  CONSTRAINT `fk_realised_ver_id` FOREIGN KEY (`realised_ver_id`) REFERENCES `project_versions` (`pv_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_realiser_user_id` FOREIGN KEY (`realiser_user_id`) REFERENCES `users` (`u_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_tr_ticket_id` FOREIGN KEY (`tr_ticket_id`) REFERENCES `tickets` (`t_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket_realisations`
--
LOCK TABLES `ticket_realisations` WRITE;
INSERT INTO `ticket_realisations` VALUES (1,1,NULL,NULL,NULL,NULL);
UNLOCK TABLES;

--
-- Table structure for table `ticket_states`
--
DROP TABLE IF EXISTS `ticket_states`;
CREATE TABLE `ticket_states` (
  `ts_id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `ticket_state` varchar(20) NOT NULL,
  PRIMARY KEY (`ts_id`),
  UNIQUE KEY `ts_id_UNIQUE` (`ts_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket_states`
--
LOCK TABLES `ticket_states` WRITE;
INSERT INTO `ticket_states` VALUES (1,'New'),(2,'Assigned'),(3,'Analysed'),(4,'Realised'),(5,'Validated'),(6,'Validation failed'),(7,'Rejected'),(8,'Cancelled'),(9,'Postponed'),(10,'Closed'),(11,'N/A');
UNLOCK TABLES;

--
-- Table structure for table `ticket_submissions`
--
DROP TABLE IF EXISTS `ticket_submissions`;
CREATE TABLE `ticket_submissions` (
  `ts_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ts_ticket_id` int(11) unsigned NOT NULL,
  `submission_ver_id` int(4) unsigned NOT NULL,
  `scheduled_ver_id` int(4) unsigned DEFAULT NULL,
  `submitter_user_id` int(7) unsigned NOT NULL,
  `submission_date` datetime NOT NULL,
  `detection_phase_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`ts_id`),
  UNIQUE KEY `ts_id_UNIQUE` (`ts_id`),
  UNIQUE KEY `ts_ticket_id_UNIQUE` (`ts_ticket_id`),
  KEY `fk_submission_ver_id_idx` (`submission_ver_id`),
  KEY `fk_submitter_id_idx` (`submitter_user_id`),
  KEY `fk_sheduled_ver_id_idx` (`scheduled_ver_id`),
  KEY `fk_detection_phase_id_idx` (`detection_phase_id`),
  KEY `fk_ts_ticket_id_idx` (`ts_ticket_id`),
  CONSTRAINT `fk_detection_phase_id` FOREIGN KEY (`detection_phase_id`) REFERENCES `detection_phases` (`dp_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_sheduled_ver_id` FOREIGN KEY (`scheduled_ver_id`) REFERENCES `project_versions` (`pv_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_submission_ver_id` FOREIGN KEY (`submission_ver_id`) REFERENCES `project_versions` (`pv_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_submitter_user_id` FOREIGN KEY (`submitter_user_id`) REFERENCES `users` (`u_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_ts_ticket_id` FOREIGN KEY (`ts_ticket_id`) REFERENCES `tickets` (`t_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket_submissions`
--
LOCK TABLES `ticket_submissions` WRITE;
INSERT INTO `ticket_submissions` VALUES (1,1,3,3,4,'2015-03-29 17:56:07',1);
UNLOCK TABLES;

--
-- Table structure for table `ticket_validations`
--
DROP TABLE IF EXISTS `ticket_validations`;
CREATE TABLE `ticket_validations` (
  `tv_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tv_ticket_id` int(11) unsigned NOT NULL,
  `validator_comments` text,
  `validated_ver_id` int(4) unsigned DEFAULT NULL,
  `validation_date` datetime DEFAULT NULL,
  `validator_user_id` int(7) unsigned DEFAULT NULL,
  `closure_date` datetime DEFAULT NULL,
  PRIMARY KEY (`tv_id`),
  UNIQUE KEY `tv_id_UNIQUE` (`tv_id`),
  UNIQUE KEY `tv_ticket_id_UNIQUE` (`tv_ticket_id`),
  KEY `fk_tv_ticket_id_idx` (`tv_ticket_id`),
  KEY `fk_validated_ver_id_idx` (`validated_ver_id`),
  KEY `fk_validator_user_id_idx` (`validator_user_id`),
  CONSTRAINT `fk_tv_ticket_id` FOREIGN KEY (`tv_ticket_id`) REFERENCES `tickets` (`t_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_validated_ver_id` FOREIGN KEY (`validated_ver_id`) REFERENCES `project_versions` (`pv_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_validator_user_id` FOREIGN KEY (`validator_user_id`) REFERENCES `users` (`u_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket_validations`
--
LOCK TABLES `ticket_validations` WRITE;
INSERT INTO `ticket_validations` VALUES (1,1,NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;

--
-- Table structure for table `ticket_workloads`
--
DROP TABLE IF EXISTS `ticket_workloads`;
CREATE TABLE `ticket_workloads` (
  `tw_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `tw_ticket_id` int(11) unsigned NOT NULL,
  `est_analysis` int(3) unsigned DEFAULT NULL,
  `est_realisation` int(3) unsigned DEFAULT NULL,
  `est_validation` int(3) unsigned DEFAULT NULL,
  `est_sum` int(4) unsigned DEFAULT NULL,
  `analysis_wl` int(3) unsigned DEFAULT NULL,
  `realisation_wl` int(3) unsigned DEFAULT NULL,
  `validation_wl` int(3) unsigned DEFAULT NULL,
  `workload_sum` int(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`tw_id`),
  UNIQUE KEY `tw_id_UNIQUE` (`tw_id`),
  UNIQUE KEY `tw_ticket_id_UNIQUE` (`tw_ticket_id`),
  KEY `fk_tw_ticket_id_idx` (`tw_ticket_id`),
  CONSTRAINT `fk_tw_ticket_id` FOREIGN KEY (`tw_ticket_id`) REFERENCES `tickets` (`t_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket_workloads`
--
LOCK TABLES `ticket_workloads` WRITE;
INSERT INTO `ticket_workloads` VALUES (1,1,0,1,0,1,NULL,NULL,NULL,NULL);
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--
DROP TABLE IF EXISTS `tickets`;
CREATE TABLE `tickets` (
  `t_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ticket_name` int(11) unsigned zerofill NOT NULL,
  `project_id` int(6) unsigned NOT NULL,
  `headline` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `severity_id` int(2) unsigned NOT NULL,
  `priority_id` int(2) unsigned NOT NULL,
  `state_id` int(2) unsigned NOT NULL,
  `linked_ticket_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_id`),
  UNIQUE KEY `t_id_UNIQUE` (`t_id`),
  UNIQUE KEY `ticket_name_UNIQUE` (`ticket_name`),
  KEY `fk_project_id_idx` (`project_id`),
  KEY `fk_t_project_id_idx` (`project_id`),
  KEY `fk_t_severity_id_idx` (`severity_id`),
  KEY `fk_t_priority_id_idx` (`priority_id`),
  KEY `fk_t_state_id_idx` (`state_id`),
  CONSTRAINT `fk_t_priority_id` FOREIGN KEY (`priority_id`) REFERENCES `priorities` (`pr_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_t_project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`p_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_t_severity_id` FOREIGN KEY (`severity_id`) REFERENCES `severities` (`s_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_t_state_id` FOREIGN KEY (`state_id`) REFERENCES `ticket_states` (`ts_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tickets`
--
LOCK TABLES `tickets` WRITE;
INSERT INTO `tickets` VALUES (1,00000000001,1,'Problems detected in specification','In requirement SwRs-0291 the part about the hash calculation uses a variable which is not defined anywhere',2,3,1,NULL);
UNLOCK TABLES;

--
-- Table structure for table `user_types`
--
DROP TABLE IF EXISTS `user_types`;
CREATE TABLE `user_types` (
  `ut_id` int(2) unsigned NOT NULL AUTO_INCREMENT,
  `user_type` varchar(20) NOT NULL,
  PRIMARY KEY (`ut_id`),
  UNIQUE KEY `ut_id_UNIQUE` (`ut_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_types`
--
LOCK TABLES `user_types` WRITE;
INSERT INTO `user_types` VALUES (1,'admin'),(2,'project manager'),(3,'developer'),(4,'validator');
UNLOCK TABLES;

--
-- Table structure for table `users`
--
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` int(7) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` varchar(32) NOT NULL,
  `user_type_id` int(2) unsigned NOT NULL,
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `u_id_UNIQUE` (`u_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_usr_type_idx` (`user_type_id`),
  CONSTRAINT `fk_u_user_type_id` FOREIGN KEY (`user_type_id`) REFERENCES `user_types` (`ut_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--
LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'admin','03c99c683998d08ae8f31b7dec65b9bf',1),(2,'ProManAdam','5f4dcc3b5aa765d61d8327deb882cf99',2),(3,'DeveloperBob','e890f806dfd189052ca7b39ac29da142',3),(4,'ValidatorChuck','d041888f2058008fb0cb6c9b7bfa2a0c',4);
UNLOCK TABLES;

-- Dump completed on 2015-03-30  0:15:15
