package com.arquitecturajava.bootnuevo.repositorios.jjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.arquitecturajava.bootnuevo.repositorios.GenericRepository;

public class GenericRepositoryJPA<T> implements GenericRepository<T> {

	@PersistenceContext
	protected EntityManager em;
	private Class<T> type;

	@Override
	public void insertar(final T tipo) {

		em.persist(tipo);

	}

	@Override
	public void borrar(final T tipo) {

		em.remove(em.merge(tipo));
	}

	@Override
	public void actualizar(final T tipo) {

		em.merge(tipo);
	}

	@Override
	public T buscarUno(final Object id) {

		return (T) em.find(type, id);
	}

	@Override
	public List<T> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
		Root<T> root = criteriaQuery.from(type);
		criteriaQuery.select(root);
		TypedQuery<T> query = em.createQuery(criteriaQuery);
		return query.getResultList();
	}

}
