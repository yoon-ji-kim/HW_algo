-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema hw
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hw
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hw` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema ssafydb
-- -----------------------------------------------------
USE `hw` ;

-- -----------------------------------------------------
-- Table `hw`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hw`.`customer` ;

CREATE TABLE IF NOT EXISTS `hw`.`customer` (
  `customer_id` INT NOT NULL,
  `customer_name` VARCHAR(10) NULL,
  `customer_address` VARCHAR(60) NULL,
  `customer_contact1` VARCHAR(13) NULL,
  `customer_contact2` VARCHAR(13) NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hw`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hw`.`product` ;

CREATE TABLE IF NOT EXISTS `hw`.`product` (
  `product_id` INT NOT NULL,
  `product_name` VARCHAR(45) NULL,
  `product_price` VARCHAR(45) NULL DEFAULT NULL,
  `product_ea` VARCHAR(45) NULL,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hw`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hw`.`order` ;

CREATE TABLE IF NOT EXISTS `hw`.`order` (
  `order_id` INT NOT NULL,
  `order_amount` VARCHAR(45) NULL,
  `order_pay` TINYINT NULL DEFAULT 'false',
  `customer_id` INT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `order_customer_id_fk_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `order_customer_id_fk`
    FOREIGN KEY (`customer_id`)
    REFERENCES `hw`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hw`.`shipping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hw`.`shipping` ;

CREATE TABLE IF NOT EXISTS `hw`.`shipping` (
  `order_id` INT NOT NULL,
  `customer_id` INT NULL,
  `shipping_done` TINYINT NULL DEFAULT 0,
  PRIMARY KEY (`order_id`),
  INDEX `shipping_customer_id_fk_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `shipping_order_id_fk`
    FOREIGN KEY (`order_id`)
    REFERENCES `hw`.`order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `shipping_customer_id_fk`
    FOREIGN KEY (`customer_id`)
    REFERENCES `hw`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
