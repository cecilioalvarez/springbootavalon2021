package com.arquitecturajava.bootnuevo.repositorios;

import java.util.List;

public interface GenericRepository<T> {

	void insertar(T tipo);

	void borrar(T tipo);

	void actualizar(T tipo);

	T buscarUno(Object id);

	List<T> buscarTodos();

}