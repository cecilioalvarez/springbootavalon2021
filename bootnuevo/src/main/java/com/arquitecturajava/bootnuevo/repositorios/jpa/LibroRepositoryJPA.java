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
//public class LibroRepositoryJPA extends GenericRepositoryJPA<Libro> implements LibroRepository {
//
//    @Override
//    public List<Libro> buscarTodosConCapitulos() {
//	// return em.createQuery("select l from Libro l join fetch l.capitulos",
//	// Libro.class).getResultList();
//	return em.createNamedQuery("Libros.buscarTodosConCapitulos", Libro.class).getResultList();
//
//    }
//
//    @Override
//    public List<Libro> buscarTituloyAutor(String titulo, String autor) {
//
//	TypedQuery<Libro> consulta = em.createQuery("select l from Libro l where l.autor=:autor and l.titulo=:titulo",
//		Libro.class);
//	consulta.setParameter("titulo", titulo);
//	consulta.setParameter("autor", autor);
//	return consulta.getResultList();
//    }
//
//    @Override
//    public List<Capitulo> buscarTodosCapitulos(Libro libro) {
//	// TODO Auto-generated method stub
//	TypedQuery<Capitulo> consulta = em.createQuery("select c from Capitulo c where c.libro.isbn=:isbn",
//		Capitulo.class);
//	consulta.setParameter("isbn", libro.getIsbn());
//	return consulta.getResultList();
//
//    }
//
//}
