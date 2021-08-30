package com.arquitecturajava.bootnuevo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Iterator;
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
@Sql({ "/schema.sql", "/data.sql" })
class BootnuevoApplicationTests2 {

    @PersistenceContext
    EntityManager em;

    @Test
       void buscarTodosLisLibrosTest() {
	TypedQuery<Libro> consulta = em.createQuery("select l from Libro l join fetch l.capitulos", Libro.class);
	List<Libro> listaLibros = consulta.getResultList();
	for (Libro libro : listaLibros) {
	    System.out.println(libro.getIsbn());
	    System.out.println(libro.getTitulo());
	    System.out.println(libro.getAutor());
	    
	    for (Capitulo c : libro.getCapitulos()) {
		System.out.println(c.getTitulo());
		System.out.println(c.getPaginas());
	    }
	}
	assertEquals(3, listaLibros.size());
    }
    
   

}
