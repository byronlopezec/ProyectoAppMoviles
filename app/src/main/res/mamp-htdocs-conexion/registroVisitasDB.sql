-- MySQL Script generated by MySQL Workbench
-- Sun Feb 18 09:08:16 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema registroVisitasDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema registroVisitasDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `registroVisitasDB` DEFAULT CHARACTER SET utf8 ;
USE `registroVisitasDB` ;

-- -----------------------------------------------------
-- Table `registroVisitasDB`.`Visita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registroVisitasDB`.`Visita` (
  `idVisita` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(20) NOT NULL,
  `fecha_visita` VARCHAR(20) NOT NULL,
  `hora_visita` VARCHAR(20) NOT NULL,
  `numero_visitantes` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idVisita`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `registroVisitasDB`.`Historial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registroVisitasDB`.`Historial` (
  `idHistorial` INT NOT NULL AUTO_INCREMENT,
  `idVisita` INT NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idHistorial`, `idVisita`),
  INDEX `fk_Historial_Visita_idx` (`idVisita` ASC),
  CONSTRAINT `fk_Historial_Visita`
    FOREIGN KEY (`idVisita`)
    REFERENCES `registroVisitasDB`.`Visita` (`idVisita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;