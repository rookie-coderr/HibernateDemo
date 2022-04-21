use my_database;

create table message (
	ID BIGINT(20) NOT NULL AUTO_INCREMENT,
    TEXT VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (ID)
);