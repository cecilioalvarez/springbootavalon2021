package com.arquitecturajava.bootnuevo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

public interface LibroRepository extends JpaRepository<Libro,String>{
	
	


  @Query 
  List<Libro> findByTituloAndAutor(String titulo, String autor);


    
  @Query
  List<Libro> buscarTodosConCapitulos();
  
  @Query("select c from Capitulo c where c.libro.isbn=:isbn")
  List<Capitulo> buscarTodosCapitulos(String isbn);
	

}