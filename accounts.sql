CREATE SCHEMA oris;
CREATE TABLE oris.accounts(
    id SERIAL,
    login VARCHAR(20) NOT NULL ,
    password VARCHAR(200) NOT NULL ,
    name VARCHAR(50) NOT NULL ,
    lastname VARCHAR(50) NOT NULL,
    CONSTRAINT id_pk PRIMARY KEY (id),
    CONSTRAINT login_uk UNIQUE (login)
);