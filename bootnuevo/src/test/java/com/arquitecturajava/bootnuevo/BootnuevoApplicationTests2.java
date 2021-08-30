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
class BootnuevoApplicationTests2 {

	@PersistenceContext
	EntityManager em;
	
	
	
	@Test
	void buscarTodosLibrosTest() {
		//No es query de SQL sino que se transformará en ello
		//Se va a la clase de negocio Libro y allí encuentra el nombre de la tabla
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l", Libro.class);

		List<Libro> listaLibros= consulta.getResultList();
		for (Libro libro : listaLibros) {
			System.out.println(libro.getIsbn()+" - "+libro.getTitulo());
			for (Capitulo c : libro.getCapitulos()) {
				System.out.println("    "+c.getTitulo()+" - "+c.getLibro().getIsbn());
			}
		}
	}
	
	
}
