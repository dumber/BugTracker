CREATE DATABASE `bugtrack` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE TABLE `detection_phases` (
  `dp_id` int(11) NOT NULL AUTO_INCREMENT,
  `phases` varchar(38) NOT NULL,
  PRIMARY KEY (`dp_id`),
  UNIQUE KEY `phases_UNIQUE` (`phases`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
CREATE TABLE `priorities` (
  `pr_id` int(11) NOT NULL AUTO_INCREMENT,
  `priority` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`pr_id`),
  UNIQUE KEY `priority_UNIQUE` (`priority`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
CREATE TABLE `project_versions` (
  `pv_id` int(11) NOT NULL AUTO_INCREMENT,
  `version` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`pv_id`),
  UNIQUE KEY `id_UNIQUE` (`pv_id`),
  UNIQUE KEY `version_UNIQUE` (`version`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
CREATE TABLE `projects` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`p_id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `p_id_UNIQUE` (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
CREATE TABLE `severities` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `severity` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`s_id`),
  UNIQUE KEY `severity_UNIQUE` (`severity`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
CREATE TABLE `ticket_states` (
  `ts_id` int(11) NOT NULL AUTO_INCREMENT,
  `state` varchar(18) DEFAULT 'Submited/New',
  PRIMARY KEY (`ts_id`),
  UNIQUE KEY `state_UNIQUE` (`state`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
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
CREATE TABLE `user_types` (
  `ut_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type` varchar(12) NOT NULL,
  PRIMARY KEY (`ut_id`),
  UNIQUE KEY `user_type_UNIQUE` (`user_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
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



