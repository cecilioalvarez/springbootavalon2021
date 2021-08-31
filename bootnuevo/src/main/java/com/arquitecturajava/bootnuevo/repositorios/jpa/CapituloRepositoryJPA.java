package com.arquitecturajava.bootnuevo.repositorios.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.repositorios.CapituloRepository;

public class CapituloRepositoryJPA implements CapituloRepository{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Capitulo> buscarTodos() {
		return em.createQuery("select c from Capitulo c", Capitulo.class).getResultList();
	}

	@Override
	public void borrar(Capitulo capitulo) {
		em.remove(em.merge(capitulo));
	}

	@Override
	public void insertar(Capitulo capitulo) {
		em.persist(capitulo);
	}

}
