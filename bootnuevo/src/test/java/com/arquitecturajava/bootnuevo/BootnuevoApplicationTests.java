package com.arquitecturajava.bootnuevo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
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
	void buscarTodosLibrosTest() {
		//No es query de SQL sino que se transformará en ello
		//Se va a la clase de negocio Libro y allí encuentra el nombre de la tabla
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);

		List<Libro> listaLibros= consulta.getResultList();
		assertEquals( 3,listaLibros.size());
	}
	
	@Test
	void buscarTodosLibrosdeCecilioTest() {
		//No es query de SQL sino que se transformará en ello
		//Se va a la clase de negocio Libro y allí encuentra el nombre de la tabla
		//TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.autor = 'Cecilio'", Libro.class);
		
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.autor = :nombre", Libro.class);
		consulta.setParameter("nombre", "Cecilio");
		List<Libro> listaLibros= consulta.getResultList();
		assertEquals( 2,listaLibros.size());
	}
	
	@Test
	void buscarUnCapituloTest() {
		Capitulo c = em.find(Capitulo.class, "intro");
		assertEquals( "intro",c.getTitulo());
		assertEquals( "2",c.getLibro().getIsbn());
	}
	
	@Test
	void buscarTodosLibrosConCapitulosTest() {
		//No es query de SQL sino que se transformará en ello
		//Se va a la clase de negocio Libro y allí encuentra el nombre de la tabla
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.capitulos is not empty", Libro.class);
		
		List<Libro> listaLibros= consulta.getResultList();
		assertEquals( 2,listaLibros.size());
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

	@Test
	@Transactional
	void insertarUnCapituloTest() {
		Libro libro1 = em.find(Libro.class, "1");
		Capitulo cNuevo = new Capitulo ("nuevo",10,libro1);
		//Persist Lanza el insert del libro
		em.persist(cNuevo);
		
		Capitulo cInsertado = em.find(Capitulo.class, "nuevo");
		assertEquals( "nuevo",cInsertado.getTitulo());
		assertEquals( 10,cInsertado.getPaginas());
		assertEquals( "1",cInsertado.getLibro().getIsbn());
	}
	
	@Test
	@Transactional
	void borrarUnCapituloTest() {
		Capitulo c1 = em.find(Capitulo.class, "intro");
		
		em.remove(c1);
		
		Capitulo c2 = em.find(Capitulo.class, "intro");
		assertNull(c2);
	}
}
