package com.arquitecturajava.bootnuevo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.arquitecturajava.bootnuevo.negocio.Libro;

@SpringBootTest
@Sql({"/schema.sql","/data.sql"})
class BootnuevoApplicationTests {

	@PersistenceContext
	EntityManager em;
	
	@Test
	void buscarUnLibroTest() {
		Libro libro = em.find(Libro.class, "1");
		assertEquals( "1",libro.getIsbn());
		assertEquals( "Cecilio",libro.getAutor());
		assertEquals( "Java",libro.getTitulo());
	}
	
	@Test
	@Transactional
	void insertarUnLibroTest() {
		Libro libro = new Libro ("4","python","Ana");
		//Persist Lanza el insert del libro
		em.persist(libro);
		
		Libro libro2 = em.find(Libro.class, "4");
		assertEquals( "4",libro2.getIsbn());
		assertEquals( "Ana",libro2.getAutor());
		assertEquals( "python",libro2.getTitulo());
	}
	
	@Test
	@Transactional
	void borrarUnLibroTest() {
		Libro libro = em.find(Libro.class, "1");
		
		em.remove(libro);
		
		Libro libroVacio = em.find(Libro.class, "1");
		assertNull(libroVacio);
	}

}
