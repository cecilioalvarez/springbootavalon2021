package com.arquitecturajava.boot.repositories;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class GenericRepositoryJPA<T> implements GenericRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;
    private final Class<T> TYPE;

    public GenericRepositoryJPA() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        this.TYPE = (Class) parameterizedType.getActualTypeArguments()[0];
    }
    
    @Override
    public Optional<T> select(final Object entity_pk) {
        return Optional.ofNullable(this.entityManager.find(this.TYPE, entity_pk));
    }
    
    @Override
    public List<T> selectAll() {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.TYPE);
        Root<T> root = criteriaQuery.from(this.TYPE);
        criteriaQuery.select(root);
        final TypedQuery<T> QUERY = entityManager.createQuery(criteriaQuery);
        return QUERY.getResultList();
    }
    
    @Override
    public void insert(final T entity) {
        this.entityManager.persist(entity);
    }
    
    @Override
    public void delete(final T entity) {
        this.entityManager.remove(this.entityManager.merge(entity));
    }
    
    @Override
    public void update(final T entity) {
        this.entityManager.merge(entity);
    }
}