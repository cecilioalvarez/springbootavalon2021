package com.arquitecturajava.bootnuevo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

//Se pasa clase y clave primaria en el JpaRepository
public interface LibroRepository extends JpaRepository<Libro,String>{

	
	
	List<Libro> buscarTodosConCapitulos();

	//List<Libro> buscarTituloyAutor(String titulo, String autor);
	
	//Uso de nomenclatura para querymethods de spring data, no paso la query
	List<Libro> findByTituloAndAutor(String titulo, String autor);
	
	//List<Capitulo> buscarTodosCapitulos(Libro libro);
	@Query("select c from Capitulo c where c.libro.isbn=:isbn")
	List<Capitulo> buscarTodosCapitulos(String isbn);

}