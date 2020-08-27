-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema goldeneye_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `goldeneye_db` ;

-- -----------------------------------------------------
-- Schema goldeneye_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `goldeneye_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `goldeneye_db` ;

-- -----------------------------------------------------
-- Table `goldeneye_db`.`units`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goldeneye_db`.`units` ;

CREATE TABLE IF NOT EXISTS `goldeneye_db`.`units` (
  `code` VARCHAR(10) NOT NULL COMMENT '单位code',
  `display` VARCHAR(100) NOT NULL COMMENT '单位显示名称',
  PRIMARY KEY (`code`))
ENGINE = InnoDB
COMMENT = '贵金属计价单元';


-- -----------------------------------------------------
-- Table `goldeneye_db`.`metals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goldeneye_db`.`metals` ;

CREATE TABLE IF NOT EXISTS `goldeneye_db`.`metals` (
  `code` VARCHAR(10) NOT NULL,
  `display` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB
COMMENT = '贵金属';


-- -----------------------------------------------------
-- Table `goldeneye_db`.`metal_price_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goldeneye_db`.`metal_price_history` ;

CREATE TABLE IF NOT EXISTS `goldeneye_db`.`metal_price_history` (
  `id` BIGINT(20) NOT NULL,
  `metal_code` VARCHAR(10) NOT NULL COMMENT '金属code',
  `unit_code` VARCHAR(10) NOT NULL COMMENT '价格单元code\n',
  `price_time` DATETIME NOT NULL COMMENT '价格时间',
  `price` FLOAT NOT NULL COMMENT '价格',
  `change` VARCHAR(10) NULL COMMENT '变动',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_metal_unit` (`metal_code` ASC, `unit_code` ASC, `price_time` ASC),
  INDEX `FK_metal_unit` (`unit_code` ASC),
  CONSTRAINT `FK_mph_metal`
    FOREIGN KEY (`metal_code`)
    REFERENCES `goldeneye_db`.`metals` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_mph_unit`
    FOREIGN KEY (`unit_code`)
    REFERENCES `goldeneye_db`.`units` (`code`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = '白银等金属的价格历史记录';


-- -----------------------------------------------------
-- Table `goldeneye_db`.`gold_price_history`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goldeneye_db`.`gold_price_history` ;

CREATE TABLE IF NOT EXISTS `goldeneye_db`.`gold_price_history` (
  `id` BIGINT(20) NOT NULL,
  `price_time` DATETIME NOT NULL COMMENT '价格时间',
  `unit_code` VARCHAR(10) NOT NULL COMMENT '计价单位',
  `buy_price` FLOAT NOT NULL COMMENT '买入价格',
  `sell_price` FLOAT NOT NULL COMMENT '卖出价格',
  `lowest_price` FLOAT NULL COMMENT '最低价格',
  `highest_price` FLOAT NULL COMMENT '最高价格',
  `change` VARCHAR(10) NULL COMMENT '变动',
  `change_percent` VARCHAR(10) NULL COMMENT '变动比例',
  `mon_change` VARCHAR(10) NULL COMMENT '30天变动',
  `mon_change_percent` VARCHAR(10) NULL COMMENT '30天变动比例',
  `year_change` VARCHAR(10) NULL COMMENT '一年变动',
  `year_change_percent` VARCHAR(10) NULL COMMENT '一年变动比例',
  PRIMARY KEY (`id`),
  INDEX `FK_golden_unit` (`unit_code` ASC),
  UNIQUE INDEX `UK_golden_unit` (`price_time` ASC, `unit_code` ASC),
  CONSTRAINT `FK_gph_unit`
    FOREIGN KEY (`unit_code`)
    REFERENCES `goldeneye_db`.`units` (`code`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB
COMMENT = '黄金价格变动历史记录';


-- -----------------------------------------------------
-- Table `goldeneye_db`.`biz_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goldeneye_db`.`biz_users` ;

CREATE TABLE IF NOT EXISTS `goldeneye_db`.`biz_users` (
  `id` BIGINT(20) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_pass` VARCHAR(100) NOT NULL,
  `telphone` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `nick_name` VARCHAR(45) NULL,
  `create_time` DATETIME NULL,
  `update_time` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_user_name` (`user_name` ASC))
ENGINE = InnoDB
COMMENT = '业务用户表';


-- -----------------------------------------------------
-- Table `goldeneye_db`.`api_secrets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `goldeneye_db`.`api_secrets` ;

CREATE TABLE IF NOT EXISTS `goldeneye_db`.`api_secrets` (
  `id` BIGINT(20) NOT NULL,
  `biz_uid` BIGINT(20) NOT NULL COMMENT '用户id',
  `api_code` VARCHAR(45) NOT NULL COMMENT 'API代码code',
  `api_secret` VARCHAR(100) NOT NULL COMMENT 'API的secret',
  `create_time` DATETIME NULL,
  `update_time` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_uid_apicode` (`biz_uid` ASC, `api_code` ASC),
  CONSTRAINT `FK_bizuser`
    FOREIGN KEY (`biz_uid`)
    REFERENCES `goldeneye_db`.`biz_users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = 'API调用的secret信息';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
