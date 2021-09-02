package com.arquitecturajava.bootnuevo.repositorios.jpa;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

import com.arquitecturajava.bootnuevo.repositorios.GenericRepository;

public class GenericRepositoryJPA<T> implements GenericRepository<T> {

    @PersistenceContext
    protected EntityManager em;
    private Class<T> type;
    
    public GenericRepositoryJPA() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }


    public void insertar(final T tipo) {
	em.persist(tipo);
    }

    public void borrar(final T tipo) {
	em.remove(em.merge(tipo));

    }
    
    public void actualizar(final T tipo) {
 	em.merge(tipo);
     }
    
    public Optional<T> buscarUno(final Object id) {
 	return Optional.ofNullable(em.find(type, id));
     }
    
    public List<T> buscarTodos() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(type);
        Root<T> root = criteriaQuery.from(type);
        criteriaQuery.select(root);
        TypedQuery<T> query = em.createQuery(criteriaQuery);
       return query.getResultList();
   }

    
    
 

}
