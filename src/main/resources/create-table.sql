CREATE DATABASE email_scheduling_db;

USE email_scheduling_db;

CREATE TABLE email_scheduling
(
    id        int          NOT NULL AUTO_INCREMENT,
    email     varchar(50)  NOT NULL,
    subject   varchar(50)  NOT NULL,
    message   varchar(255) NOT NULL,
    scheduled tinytext     NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 18
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
