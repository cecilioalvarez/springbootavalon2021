package com.arquitecturajava.bootnuevo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//implements CommandLineRunner
@SpringBootApplication
public class BootnuevoApplication {

	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(BootnuevoApplication.class, args);
	}

	/*
	 * @Override
	 * 
	 * @Transactional public void run(String... args) throws Exception {
	 * 
	 * TypedQuery<Libro> consulta =
	 * em.createQuery("select distinct l from Libro l left join fetch l.capitulos",
	 * Libro.class);
	 * 
	 * List<Libro> lista = consulta.getResultList();
	 * 
	 * for (Libro l : lista) {
	 * 
	 * System.out.println(l.getIsbn()); System.out.println(l.getTitulo());
	 * System.out.println(l.getAutor());
	 * 
	 * 
	 * for (Capitulo c : l.getCapitulos()) {
	 * 
	 * System.out.println(c.getTitulo()); } } }
	 */
}
