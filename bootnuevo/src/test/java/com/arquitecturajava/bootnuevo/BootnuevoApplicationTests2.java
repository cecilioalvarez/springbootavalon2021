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
class BootnuevoApplicationTests2 {

	@PersistenceContext
	EntityManager em;

	@Test
	void buscarTodosLosLibros() {

		
		TypedQuery<Libro> consulta= em.createQuery("select l from Libro l", Libro.class);
		
		List<Libro> lista= consulta.getResultList();
		
		for (Libro l: lista) {
			
			System.out.println(l.getIsbn());
			System.out.println(l.getTitulo());
			System.out.println(l.getAutor());
			
			for (Capitulo c: l.getCapitulos()) {
				
				System.out.println(c.getTitulo());
			}
		}
		

	}

	

}
