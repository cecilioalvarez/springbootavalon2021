package com.arquitecturajava.bootnuevo.repositorios;

import java.util.List;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

public interface LibroRepository extends GenericRepository<Libro> {

	List<Libro> buscarTodosConCapitulos();

	List<Libro> buscarTituloyAutor(String titulo, String autor);

	List<Capitulo> buscarTodosCapitulos(Libro libro);

}