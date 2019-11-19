-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ctw
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ctw
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ctw` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ctw` ;

-- -----------------------------------------------------
-- Table `ctw`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctw`.`Order` (
  `idOrder` INT(11) NOT NULL AUTO_INCREMENT,
  `owner` VARCHAR(255) NOT NULL,
  `date` DATETIME NOT NULL,
  `total` DECIMAL(15,0) NOT NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `owner_of_order_idx` (`owner` ASC) VISIBLE,
  CONSTRAINT `owner_of_order`
    FOREIGN KEY (`owner`)
    REFERENCES `ctw`.`applicationuser` (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ctw`.`OrderProduct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctw`.`OrderProduct` (
  `idProduct` INT(11) NOT NULL,
  `idOrder` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL,
  PRIMARY KEY (`idProduct`, `idOrder`),
  INDEX `idOrder_FK_idx` (`idOrder` ASC) VISIBLE,
  CONSTRAINT `idOrder_FK`
    FOREIGN KEY (`idOrder`)
    REFERENCES `ctw`.`order` (`idOrder`),
  CONSTRAINT `idProduct_FK`
    FOREIGN KEY (`idProduct`)
    REFERENCES `ctw`.`product` (`idProduct`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ctw`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctw`.`Product` (
  `idProduct` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `price` FLOAT NOT NULL,
  `stock` INT(11) NOT NULL,
  `product_image` LONGBLOB NULL DEFAULT NULL,
  `seller` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idProduct`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ctw`.`applicationUser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctw`.`applicationUser` (
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `role` INT(11) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ctw`.`wishlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctw`.`wishlist` (
  `email` VARCHAR(45) NOT NULL,
  `idProduct` INT(11) NOT NULL,
  PRIMARY KEY (`email`, `idProduct`),
  INDEX `idProduct_idx` (`idProduct` ASC) VISIBLE,
  CONSTRAINT `email`
    FOREIGN KEY (`email`)
    REFERENCES `ctw`.`applicationuser` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idProduct`
    FOREIGN KEY (`idProduct`)
    REFERENCES `ctw`.`product` (`idProduct`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
