package com.arquitecturajava.bootnuevo.repositorios;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T> {

    void insertar(T tipo);

    void borrar(T tipo);

    void actualizar(T tipo);

    Optional<T> buscarUno(Object id);

    List<T> buscarTodos();

}