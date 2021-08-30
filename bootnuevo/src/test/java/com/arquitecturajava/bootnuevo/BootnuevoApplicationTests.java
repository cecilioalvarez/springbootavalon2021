package com.arquitecturajava.bootnuevo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
