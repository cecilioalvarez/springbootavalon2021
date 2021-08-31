package com.arquitecturajava.bootnuevo.repositorios.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.repositorios.CapituloRepository;

@Repository
@Qualifier("jpa")
public class CapituloRepositoryJPA implements CapituloRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Capitulo> buscarTodos() {
		// TODO Auto-generated method stu
		return em.createQuery("Select c from Capitulo c", Capitulo.class).getResultList();
	}

	@Override
	public void borrar(Capitulo capitulo) {
		// TODO Auto-generated method stub
		em.remove(em.merge(capitulo));
	}

	@Override
	public void insertar(Capitulo capitulo) {
		em.persist(capitulo);

	}

}
