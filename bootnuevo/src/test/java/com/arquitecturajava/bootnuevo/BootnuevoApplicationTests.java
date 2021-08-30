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
@Sql({ "/esquema.sql", "/data.sql" })
class BootnuevoApplicationTests {

	// Vamos a generar pruebas unitarias contra la BBDD con JPA
	@PersistenceContext
	EntityManager em;

	@Test
	void buscarUnLibroTest() {
		Libro libro = em.find(Libro.class, "1");
		assertEquals("1", libro.getIsbn());
		assertEquals("Java", libro.getTitulo());
		assertEquals("Cecilio", libro.getAutor());
	}

	@Test
	void buscarTodosLibrosTest() {
		Capitulo c = em.find(Capitulo.class, "intro");
		assertEquals("intro", c.getTitulo());
		assertEquals("1", c.getLibro().getIsbn());
	}

	@Test
	void buscarUnCapituloTest() {

		TypedQuery<Libro> consulta = em.createQuery("Select l from Libro l", Libro.class);
		List<Libro> listalibros = consulta.getResultList();
		assertEquals(3, listalibros.size());
	}

	@Test
	void buscarTodosLosLibrosConCapitulosTest() {

		TypedQuery<Libro> consulta = em.createQuery("Select l from Libro l where l.capitulos is not empty",
				Libro.class);
		List<Libro> listalibros = consulta.getResultList();
		assertEquals(2, listalibros.size());
	}

	@Test
	void buscarTodosLibrosCecilioTest() {

		TypedQuery<Libro> consulta = em.createQuery("Select l from Libro l" + " where l.autor=:nombre", Libro.class);
		consulta.setParameter("nombre", "Cecilio");
		List<Libro> listalibros = consulta.getResultList();
		assertEquals(2, listalibros.size());
	}

	@Test
	@Transactional
	void insertarUnLibroTest() {
		Libro libro = new Libro("4", "python", "ana");
		// em.getTransaction().begin();
		em.persist(libro);

		Libro libro2 = em.find(Libro.class, "4");
		assertEquals("4", libro2.getIsbn());
		assertEquals("python", libro2.getTitulo());
		assertEquals("ana", libro2.getAutor());
		// em.getTransaction().commit();
	}

	@Test
	@Transactional
	void insertarUnCapituloTest() {
		Libro libro = em.find(Libro.class, "1");
		Capitulo cNuevo = new Capitulo("nuevo", 12, libro);

		// em.getTransaction().begin();
		em.persist(cNuevo);

		Capitulo cSalvado = em.find(Capitulo.class, "nuevo");
		assertEquals("nuevo", cSalvado.getTitulo());
		assertEquals("1", cSalvado.getLibro().getIsbn());
		assertEquals(12, cSalvado.getPaginas());
		// em.getTransaction().commit();
	}

	@Test
	@Transactional
	void insertarUnLibroDuplicadoTest() {
		Libro libro = new Libro("1", "Java", "Cecilio");
		em.persist(libro);
		assertThrows(PersistenceException.class, () -> em.flush());
	}

	@Test
	@Transactional
	void borrarUnLibroTest() {
		Libro libro = em.find(Libro.class, "1");
		// em.getTransaction().begin();
		em.remove(libro);

		Libro librovacio = em.find(Libro.class, "1");
		assertNull(librovacio);
	}

	@Test
	@Transactional
	void borrarUnCapituloTest() {
		Capitulo cap = em.find(Capitulo.class, "intro");
		// em.getTransaction().begin();
		em.remove(cap);

		Capitulo capituloVacio = em.find(Capitulo.class, "intro");
		assertNull(capituloVacio);
	}
}
