package com.arquitecturajava.bootnuevo.servicios;

import java.util.List;
import java.util.Optional;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

public interface LibroService {

	void actualizar(Libro libro);

	void insertar(Libro libro);

	void borrar(Libro libro);

	List<Libro> buscarTodos();

	List<Libro> buscarTodosConCapitulos();

	List<Libro> buscarTituloyAutor(String titulo, String autor);

	Optional<Libro> buscarUno(String isbn);
	
	List<Capitulo> buscarTodosLosCapitulos() ;
	List<Capitulo> buscarTodosCapitulos(Libro libro) ;
	
	void borrarCapitulo(Capitulo capitulo);
	void insertarCapitulo(Capitulo capitulo);
	void insertarVariosLibros(Libro ...libros );

}