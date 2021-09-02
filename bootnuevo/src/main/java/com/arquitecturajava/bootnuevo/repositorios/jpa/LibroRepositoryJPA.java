//package com.arquitecturajava.bootnuevo.repositorios.jpa;
//
//import java.util.List;
//
//import javax.persistence.TypedQuery;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Repository;
//
//import com.arquitecturajava.bootnuevo.negocio.Capitulo;
//import com.arquitecturajava.bootnuevo.negocio.Libro;
//import com.arquitecturajava.bootnuevo.repositorios.LibroRepository;
//
//@Repository
//@Qualifier("jpa")
//public class LibroRepositoryJPA /*implements LibroRepository*/ extends GenericRepositoryJPA<Libro> implements LibroRepository {
//
///*
//	@PersistenceContext
//	EntityManager em;
//	
//	@Override
//	public void actualizar(Libro libro) {
//		em.merge(libro);
//		
//	}
//
//	@Override
//	public void insertar(Libro libro) {
//		em.persist(libro);
//	}
//
//	@Override
//	public void borrar(Libro libro) {
//		em.remove(em.merge(libro));
//		
//	}
//
//	@Override
//	public List<Libro> buscarTodos() {
//		//Se puede hacer con esta linea solo
//		//return em.createQuery("select l from Libro l", Libro.class).getResultList();
//		//Con esta forma necesitamos en namedQuery en la clase libro
//		return em.createNamedQuery("Libros.buscarTodos", Libro.class).getResultList();
//	}
//*/
//	@Override
//	public List<Libro> buscarTodosConCapitulos() {
//		//Igual que en el metodo anterior de buscar todos se pueden hacer de las dos maneras
//		//return em.createQuery("select l from Libro l join fetch l.capitulos", Libro.class).getResultList();
//		return em.createNamedQuery("Libros.buscarTodosConCapitulos", Libro.class).getResultList();
//	}
//
//	@Override
//	public List<Libro> buscarTituloyAutor(String titulo, String autor) {
//		TypedQuery<Libro> consulta=em.createQuery("select l from Libro l where l.autor=:autor and l.titulo=:titulo", Libro.class);
//		consulta.setParameter("titulo", titulo);
//		consulta.setParameter("autor", autor);
//		return consulta.getResultList();
//	}
///*
//	@Override
//	public Libro buscarUno(String isbn) {
//		return em.find(Libro.class, isbn);
//	}*/
//
//	@Override
//	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
//		TypedQuery<Capitulo> consulta = em.createQuery("select c from Capitulo c where c.libro.isbn=:isbn", Capitulo.class);
//		consulta.setParameter("isbn", libro.getIsbn());
//		return consulta.getResultList();
//	}
//}
