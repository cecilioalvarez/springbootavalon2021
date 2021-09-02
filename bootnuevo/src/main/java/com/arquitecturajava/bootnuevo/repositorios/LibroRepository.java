package com.arquitecturajava.bootnuevo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

public interface LibroRepository extends JpaRepository<Libro,String>{

	
	
	List<Libro> buscarTodosConCapitulos();

	List<Libro> buscarTituloyAutor(String titulo, String autor);
	
	List<Capitulo> buscarTodosCapitulos(Libro libro);

}