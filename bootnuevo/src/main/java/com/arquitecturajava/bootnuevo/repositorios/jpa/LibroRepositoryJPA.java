package com.arquitecturajava.bootnuevo.repositorios.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;
import com.arquitecturajava.bootnuevo.repositorios.LibroRepository;

@Repository
@Qualifier("jpa")
public class LibroRepositoryJPA implements LibroRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public void actualizar(Libro libro) {
		em.merge(libro);

	}

	@Override
	public void insertar(Libro libro) {
		em.persist(libro);

	}

	@Override
	public void borrar(Libro libro) {
		em.remove(em.merge(libro));

	}

	@Override
	public List<Libro> buscarTodos() {
		
		return em.createNamedQuery("Libros.buscarTodos",Libro.class).getResultList();
	}

	@Override
	public List<Libro> buscarTodosConCapitulos() {
		// TODO Auto-generated method stub
		 	return em.createNamedQuery("Libros.buscarTodosConCapitulos",Libro.class).getResultList();
	}


	@Override
	public List<Libro> buscarTituloyAutor(String titulo, String autor) {
		// TODO Auto-generated method stub
		TypedQuery<Libro> consulta=em.createQuery("select l from Libro l where l.autor=:autor and l.titulo=:titulo",Libro.class);
		consulta.setParameter("titulo", titulo);
		consulta.setParameter("autor", autor);
		return consulta.getResultList();
	}

	@Override
	public Libro buscarUno(String isbn) {

		return em.find(Libro.class, isbn);
	}

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
		// TODO Auto-generated method stub
		TypedQuery<Capitulo> consulta= em.createQuery("select c from Capitulo c where c.libro.isbn=:isbn",Capitulo.class);
		consulta.setParameter("isbn", libro.getIsbn());
		return consulta.getResultList();
	}

}
