USE test;

DROP TABLE IF EXISTS parts;
CREATE TABLE parts(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    `need` TINYINT NULL,
    `count` INT NULL,
    PRIMARY KEY (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `parts` (`name`, `need`, `count`) VALUES ('Матероинская плата', true, 3);
INSERT INTO `parts` (`name`, `need`, `count`) VALUES ('Звуковая плата', false, 2);
INSERT INTO `parts` (`name`, `need`, `count`) VALUES ('Процессор', true, 2);
INSERT INTO `parts` (`name`, `need`, `count`) VALUES ('Подсветка корпуса', false, 0);
INSERT INTO `parts` (`name`, `need`, `count`) VALUES ('HDD диск', false, 1);
INSERT INTO `parts` (`name`, `need`, `count`) VALUES ('Корпус', true, 10);
INSERT INTO `parts` (`name`, `need`, `count`) VALUES ('Память', true, 10);
INSERT INTO `parts` (`name`, `need`, `count`) VALUES ('SSD диск', true, 15);
INSERT INTO `parts` (`name`, `need`, `count`) VALUES ('Видеокарта', false, 7);