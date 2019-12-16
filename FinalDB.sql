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
-- Table `ctw`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctw`.`message` (
  `idmessage` INT(11) NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(200) NOT NULL,
  `body` VARCHAR(2000) NOT NULL,
  `sender` VARCHAR(255) NOT NULL,
  `recipient` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`idmessage`),
  INDEX `fk_message_applicationUser1_idx` (`sender` ASC) VISIBLE,
  INDEX `fk_message_applicationUser2_idx` (`recipient` ASC) VISIBLE,
  CONSTRAINT `fk_message_applicationUser1`
    FOREIGN KEY (`sender`)
    REFERENCES `ctw`.`applicationuser` (`email`),
  CONSTRAINT `fk_message_applicationUser2`
    FOREIGN KEY (`recipient`)
    REFERENCES `ctw`.`applicationuser` (`email`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ctw`.`myOrder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctw`.`myOrder` (
  `idOrder` INT(11) NOT NULL AUTO_INCREMENT,
  `owner` VARCHAR(255) NOT NULL,
  `date`  VARCHAR(255) NOT NULL,
  `total` DECIMAL(15,0) NOT NULL,
  PRIMARY KEY (`idOrder`),
  INDEX `owner_of_order_idx` (`owner` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ctw`.`oldProduct`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctw`.`oldProduct` (
  `idOldProduct` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `pricePerUnit` FLOAT NOT NULL,
  `units` INT(11) NOT NULL,
  `productImage` LONGBLOB NULL DEFAULT NULL,
  `myOrder` INT(11) NOT NULL,
  `seller` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idOldProduct`),
  INDEX `fk_oldProduct_myOrder1_idx` (`myOrder` ASC) VISIBLE,
  INDEX `fk_oldProduct_applicationUser1_idx` (`seller` ASC) VISIBLE,
  CONSTRAINT `fk_oldProduct_applicationUser1`
    FOREIGN KEY (`seller`)
    REFERENCES `ctw`.`applicationuser` (`email`),
  CONSTRAINT `fk_oldProduct_myOrder1`
    FOREIGN KEY (`myOrder`)
    REFERENCES `ctw`.`myorder` (`idOrder`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ctw`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctw`.`product` (
  `idProduct` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `price` FLOAT NOT NULL,
  `stock` INT(11) NOT NULL,
  `product_image` LONGBLOB NULL DEFAULT NULL,
  `seller` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idProduct`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ctw`.`applicationUser_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ctw`.`applicationUser_has_product` (
  `applicationUser_email` VARCHAR(255) NOT NULL,
  `product_idProduct` INT(11) NOT NULL,
  PRIMARY KEY (`applicationUser_email`, `product_idProduct`),
  INDEX `fk_applicationUser_has_product_product1_idx` (`product_idProduct` ASC) VISIBLE,
  INDEX `fk_applicationUser_has_product_applicationUser1_idx` (`applicationUser_email` ASC) VISIBLE,
  CONSTRAINT `fk_applicationUser_has_product_applicationUser1`
    FOREIGN KEY (`applicationUser_email`)
    REFERENCES `ctw`.`applicationUser` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_applicationUser_has_product_product1`
    FOREIGN KEY (`product_idProduct`)
    REFERENCES `ctw`.`product` (`idProduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO ctw.applicationUser
VALUES('tester1@gmail.com', '12345', 'TesterFirst1', 'TesterFirst2', '16 Tester ave.', 0);
INSERT INTO ctw.applicationUser
VALUES('tester2@gmail.com', '12345', 'TesterFirst2', 'TesterFirst2', '18 Tester St.', 0);
INSERT INTO ctw.applicationUSer
VALUES('admin@gmail.com', '12345', 'admin', 'adminMan', '18 sudo st.', 2);
INSERT INTO ctw.applicationUser
VALUES('seller@gmail.com', '12345', 'seller', 'Jim', '16 seller st.', 1);
INSERT INTO ctw.applicationUser
VALUES('seller2@gmail.com', '12345', 'other', 'seller', '17 seller ave.', 1);

INSERT INTO ctw.product
VALUES('1', 'Car', 'This is the first sample product', '10.00', '5', null, 'seller@gmail.com');
INSERT INTO ctw.product
VALUES('2', 'Plane', 'This is the second sample product', '20.00', '10', null, 'seller2@gmail.com');

INSERT INTO ctw.applicationUser_has_product
VALUES('tester1@gmail.com',2);

INSERT INTO ctw.message
VALUES(1,'first message to all shoppers','this was generated using the SQL script. hi shoppers.','seller@gmail.com', null);

INSERT INTO ctw.message
VALUES(2,'first message to seller@gmail.com','this was generated using the SQL script. hi seller Jim. Love, tester1@gmail.com.','tester1@gmail.com','seller@gmail.com');

INSERT INTO ctw.message
VALUES (3, 'message to tester1', 'hey there tester1', 'seller@gmail.com', 'tester1@gmail.com');

INSERT INTO ctw.myOrder
VALUES(1,'tester1@gmail.com','2019-11-21 14:44:04',4.95);

INSERT INTO ctw.oldProduct
VALUES(1,'Car','Old Description',0.99,5,null,1,'seller@gmail.com');
