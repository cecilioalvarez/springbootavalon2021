package com.arquitecturajava.boot.repositories;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T> {

    void delete(final T entity);

    void insert(final T entity);

    Optional<T> select(final Object entity_pk);

    List<T> selectAll();

    void update(final T entity);
}