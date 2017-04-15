-- MySQL Script generated by MySQL Workbench
-- Mon Apr 10 20:42:18 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema biaojiang
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biaojiang
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biaojiang` DEFAULT CHARACTER SET utf8 ;
USE `biaojiang` ;

-- -----------------------------------------------------
-- Table `biaojiang`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`user` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `cellphone_no` VARCHAR(20) NULL,
  `password` VARCHAR(20) NULL,
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`app_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`app_type` (
  `app_type_id` BIGINT NOT NULL AUTO_INCREMENT,
  `app_type_name` VARCHAR(10) NOT NULL,
  `desc` VARCHAR(45) NULL,
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`app_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`user_app`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`user_app` (
  `user_app_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `app_type_id` BIGINT NOT NULL,
  `user_biz_id` VARCHAR(50) NOT NULL,
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`user_app_id`),
  INDEX `fk_app_user_app1_idx` (`app_type_id` ASC),
  INDEX `fk_app_user_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_app_user_app1`
    FOREIGN KEY (`app_type_id`)
    REFERENCES `biaojiang`.`app_type` (`app_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_app_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `biaojiang`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`template`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`template` (
  `template_id` BIGINT NOT NULL AUTO_INCREMENT,
  `template_name` VARCHAR(45) NOT NULL,
  `desc` VARCHAR(50) NULL,
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`template_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`user_template`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`user_template` (
  `user_template_id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `template_id` BIGINT NOT NULL,
  `is_admin` CHAR(1) NOT NULL DEFAULT 0 COMMENT '0：非管理员\n1：管理员',
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`user_template_id`),
  INDEX `fk_user_has_template_template1_idx` (`template_id` ASC),
  INDEX `fk_user_has_template_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_template_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `biaojiang`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_template_template1`
    FOREIGN KEY (`template_id`)
    REFERENCES `biaojiang`.`template` (`template_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`node_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`node_type` (
  `node_type_id` BIGINT NOT NULL AUTO_INCREMENT,
  `node_type_name` VARCHAR(45) NOT NULL,
  `desc` VARCHAR(45) NULL,
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`node_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`node`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`node` (
  `node_id` BIGINT NOT NULL AUTO_INCREMENT,
  `parent_node_id` BIGINT NOT NULL DEFAULT 0,
  `node_type_id` BIGINT NOT NULL,
  `template_id` BIGINT NOT NULL,
  `node_name` VARCHAR(45) NOT NULL,
  `position` INT NOT NULL,
  `is_required` CHAR(1) NULL DEFAULT 0 COMMENT '0：选填项\n1：必填项',
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`node_id`),
  INDEX `fk_node_node_type1_idx` (`node_type_id` ASC),
  INDEX `fk_node_template1_idx` (`template_id` ASC),
  CONSTRAINT `fk_node_node_type1`
    FOREIGN KEY (`node_type_id`)
    REFERENCES `biaojiang`.`node_type` (`node_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_node_template1`
    FOREIGN KEY (`template_id`)
    REFERENCES `biaojiang`.`template` (`template_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`report`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`report` (
  `report_id` BIGINT NOT NULL AUTO_INCREMENT,
  `template_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `report_name` VARCHAR(45) NOT NULL,
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`report_id`),
  INDEX `fk_reprot_template1_idx` (`template_id` ASC),
  INDEX `fk_reprot_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_reprot_template1`
    FOREIGN KEY (`template_id`)
    REFERENCES `biaojiang`.`template` (`template_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reprot_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `biaojiang`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`attachment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`attachment_type` (
  `attachement_type_id` BIGINT NOT NULL AUTO_INCREMENT,
  `attachment_type_name` VARCHAR(45) NOT NULL,
  `desc` VARCHAR(45) NULL,
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`attachement_type_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`report_node_value`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`report_node_value` (
  `value_id` BIGINT NOT NULL AUTO_INCREMENT,
  `report_id` BIGINT NOT NULL,
  `node_id` BIGINT NOT NULL,
  `value` VARCHAR(500) NULL,
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`value_id`),
  INDEX `fk_node_value_report1_idx` (`report_id` ASC),
  INDEX `fk_node_value_node1_idx` (`node_id` ASC),
  CONSTRAINT `fk_node_value_report1`
    FOREIGN KEY (`report_id`)
    REFERENCES `biaojiang`.`report` (`report_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_node_value_node1`
    FOREIGN KEY (`node_id`)
    REFERENCES `biaojiang`.`node` (`node_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`attachment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`attachment` (
  `attachment_id` BIGINT NOT NULL AUTO_INCREMENT,
  `attachement_type_id` BIGINT NOT NULL,
  `value_id` BIGINT NOT NULL,
  `url` VARCHAR(100) NOT NULL,
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`attachment_id`),
  INDEX `fk_attachment_attachment_type1_idx` (`attachement_type_id` ASC),
  INDEX `fk_attachment_report_node_value1_idx` (`value_id` ASC),
  CONSTRAINT `fk_attachment_attachment_type1`
    FOREIGN KEY (`attachement_type_id`)
    REFERENCES `biaojiang`.`attachment_type` (`attachement_type_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_attachment_report_node_value1`
    FOREIGN KEY (`value_id`)
    REFERENCES `biaojiang`.`report_node_value` (`value_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biaojiang`.`configuration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biaojiang`.`configuration` (
  `config_id` BIGINT NOT NULL AUTO_INCREMENT,
  `config_key` VARCHAR(45) NOT NULL,
  `config_value` VARCHAR(45) NOT NULL,
  `desc` VARCHAR(45) NOT NULL,
  `group_key` VARCHAR(45) NULL,
  `creator` BIGINT NULL,
  `create_time` TIMESTAMP NULL,
  `modifier` BIGINT NULL,
  `modify_time` TIMESTAMP NULL,
  PRIMARY KEY (`config_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;