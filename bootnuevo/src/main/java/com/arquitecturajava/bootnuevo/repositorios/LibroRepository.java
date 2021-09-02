package com.arquitecturajava.bootnuevo.repositorios;

import java.util.List;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

public interface LibroRepository extends GenericRepository<Libro> {

	/*void actualizar(Libro libro);

	void insertar(Libro libro);

	void borrar(Libro libro);

	List<Libro> buscarTodos();*/
	
	List<Libro> buscarTodosConCapitulos();

	List<Libro> buscarTituloyAutor(String titulo, String autor);

	/*Libro buscarUno(String isbn);*/
	
	List<Capitulo> buscarTodosCapitulos(Libro libro);

}