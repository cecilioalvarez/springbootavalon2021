DROP TABLE IF EXISTS Capitulos;
DROP TABLE IF EXISTS Libros;
create table Capitulos (titulo varchar(25), paginas int, libros_isbn varchar(10));
create table Libros (isbn varchar(10), titulo varchar(25),autor varchar(25), primary key (isbn));

