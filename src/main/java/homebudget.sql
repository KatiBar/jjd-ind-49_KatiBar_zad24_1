CREATE SCHEMA `budget` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;

CREATE TABLE `budget`.`homebudget` (
                                       `id` INT NOT NULL AUTO_INCREMENT,
                                       `type` VARCHAR(1) NULL,
                                       `description` VARCHAR(50) NULL,
                                       `amount` DOUBLE NULL,
                                       `date` DATE NULL,
                                       PRIMARY KEY (`id`));

INSERT INTO budget.homebudget(type, description, amount, date)
VALUES
    ('W', 'opis1', 569.59, '2023-03-20'),
    ('P', 'opis2', 1569.59, '2023-03-21'),
    ('W', 'opis3', 69.59, '2022-02-20');

SELECT * FROM homebudget;