-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ssafit
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafit` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ssafit` ;

-- -----------------------------------------------------
-- Table `ssafit`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(40) NOT NULL,
  `nickname` VARCHAR(40) NOT NULL,
  `user_id` VARCHAR(40) NOT NULL,
  `height` INT NOT NULL,
  `weight` INT NOT NULL,
  `exp` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafit`.`calendar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`calendar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `date` DATE NULL DEFAULT NULL,
  `timesum` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_calendar_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafit`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafit`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`comment` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `youtube_Id` VARCHAR(80) NOT NULL,
  `content` VARCHAR(160) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_comment_nickname_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_nickname`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafit`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafit`.`exercise`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`exercise` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `name` VARCHAR(40) NOT NULL,
  `time` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_exercise_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_exercise_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafit`.`user` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafit`.`group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`grouptable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `master` VARCHAR(40) NOT NULL,
  `password` VARCHAR(40) NULL DEFAULT NULL,
  `detail` VARCHAR(80) NULL DEFAULT NULL,
  `notice` VARCHAR(40) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ssafit`.`linktable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`linktable` (
  `userid` INT NOT NULL,
  `groupid` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  INDEX `fk_linktable_userid_idx` (`userid` ASC) VISIBLE,
  INDEX `fk_linktable_groupid_idx` (`groupid` ASC) VISIBLE,
  CONSTRAINT `fk_linktable_userid`
    FOREIGN KEY (`userid`)
    REFERENCES `ssafit`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_linktable_groupid`
    FOREIGN KEY (`groupid`)
    REFERENCES `ssafit`.`grouptable` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
