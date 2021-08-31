DROP TABLE IF EXISTS Capitulos;
DROP TABLE IF EXISTS Libros;
DROP TABLE IF EXISTS Editoriales;
create table Capitulos (titulo varchar(25), paginas int, libros_isbn varchar(10));
create table Editoriales (nombre varchar(20),categoria varchar(20),primary key (nombre));
create table Libros (isbn varchar(10), titulo varchar(25),autor varchar(25),editoriales_nombre varchar (20), primary key (isbn));