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
public class LibroRepositoryJPA implements LibroRepository{

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
		//primero merge para tener objeto en memoria para que jpa pueda trabajar con el
		//jpa sólo puede trabajar con las entidades que hayan sido gestionadas 
		//y estén en la memoria del EntityManager, por eso primero merge y después remove
		
		em.remove(em.merge(libro));
		
	}

	@Override
	public List<Libro> buscarTodos() {
		
		//return em.createQuery("select l from Libro l",Libro.class).getResultList();
		//Uso de NamedQuery en clase de negocio Libro
		return em.createNamedQuery("Libros.buscarTodos",Libro.class).getResultList();
	
	}

	@Override
	public List<Libro> buscarTodosConCapitulos() {

		//return em.createQuery("select l from Libro l join fetch l.capitulos",Libro.class).getResultList();
		//Uso de NamedQuery en clase de negocio Libro
		return em.createNamedQuery("Libros.buscarTodosConCapitulos",Libro.class).getResultList();
	}

	@Override
	public List<Libro> buscarTituloyAutor(String titulo, String autor) {
		TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.autor=:autor and l.titulo=:titulo",Libro.class);
		consulta.setParameter("autor", autor);
		consulta.setParameter("titulo", titulo);
		return consulta.getResultList();
	}

	@Override
	public Libro buscarUno(String isbn) {
		
		return em.find(Libro.class, isbn);
	}

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
		TypedQuery<Capitulo> consulta = em.createQuery("select c from Capitulo c where c.libro.isbn=:isbn",Capitulo.class);
		consulta.setParameter("isbn", libro.getIsbn());
		return consulta.getResultList();
	}

}
