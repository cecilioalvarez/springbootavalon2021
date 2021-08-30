package com.arquitecturajava.bootnuevo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

@SpringBootTest
@Sql({ "/schema.sql", "/data.sql" })
class BootnuevoApplicationTests {

	@PersistenceContext
	EntityManager em;

	@Test
	void buscarUnLibroTest() {

		Libro libro = em.find(Libro.class, "1");
		assertEquals("1", libro.getIsbn());
		assertEquals("Cecilio", libro.getAutor());
		assertEquals("Java", libro.getTitulo());

	}

	@Test
	void buscarTodosLosLibrosTest() {

		// consulta de JPA query languaje
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);
		List<Libro> listaLibros = consulta.getResultList();
		assertEquals(3, listaLibros.size());

	}

	@Test
	void buscarTodosLosLibrosDeCecilioTest() {

		// consulta de JPA query languaje
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l" + " where l.autor=:nombre", Libro.class);
		consulta.setParameter("nombre", "Cecilio");
		List<Libro> listaLibros = consulta.getResultList();
		assertEquals(2, listaLibros.size());

	}

	@Test
	@Transactional
	void insertarUnLibroTest() {

		Libro libro = new Libro("4", "Python", "Ana");
		em.persist(libro);

		Libro libro2 = em.find(Libro.class, "4");
		assertEquals("4", libro2.getIsbn());
		assertEquals("Ana", libro2.getAutor());
		assertEquals("Python", libro2.getTitulo());

	}
	
	@Test
	@Transactional
	void insertarUnCapitulo() {

	

		Libro libro1 = em.find(Libro.class, "1");
		Capitulo cNuevo= new Capitulo("nuevo",10,libro1);
		em.persist(cNuevo);
		Capitulo cSalvado= em.find(Capitulo.class, "nuevo");
		assertEquals("nuevo", cSalvado.getTitulo());
		assertEquals(10, cSalvado.getPaginas());
		assertEquals("1", cSalvado.getLibro().getIsbn());

	}
	
	@Test
	@Transactional
	void borrarUnCapitulo() {

	
		Capitulo c1 = em.find(Capitulo.class, "intro");
		em.remove(c1);
	
		Capitulo c2 = em.find(Capitulo.class, "intro");
		assertNull(c2);
		
	}
	
	

	@Test

	void buscarUnCapitulo() {

		Capitulo c = em.find(Capitulo.class, "intro");
		assertEquals("intro", c.getTitulo());

	}

	void buscarTodosLibrosConCapitulosTest() {

		
		TypedQuery<Libro> consulta= em.createQuery ("select l from Libro l "
				+ "where l.capitulos is not empty",Libro.class);

		List<Libro> lista= consulta.getResultList();
		
		assertEquals(2,lista.size());
		
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
