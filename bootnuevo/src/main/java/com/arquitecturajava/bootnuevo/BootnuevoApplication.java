package com.arquitecturajava.bootnuevo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

@SpringBootApplication
public class BootnuevoApplication implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;
	
	public static void main(String[] args) {
		SpringApplication.run(BootnuevoApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		TypedQuery<Libro> consulta = em.createQuery("select distinct l from Libro l join fetch l.capitulos", Libro.class);
		List<Libro> lista = consulta.getResultList();
		for(Libro l: lista) {
			System.out.println(l.getIsbn());
			System.out.println(l.getTitulo());
			System.out.println(l.getAutor());
			for(Capitulo c: l.getCapitulos()) {
				System.out.println(c.getTitulo());
			}
		}
		
	}

}
