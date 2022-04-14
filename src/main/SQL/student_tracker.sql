DROP TABLE IF EXISTS student;

CREATE TABLE student (
                         id INT  primary key GENERATED ALWAYS AS IDENTITY,
                         first_name varchar(45) DEFAULT NULL,
                         last_name varchar(45) DEFAULT NULL,
                         email varchar(45) DEFAULT NULL
);