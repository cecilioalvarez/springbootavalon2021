DROP TABLE IF EXISTS book;

CREATE TABLE book (
    pk_isbn VARCHAR(10), 
    title VARCHAR(25),
    fk_author VARCHAR(25)
);