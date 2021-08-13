package com.arquitecturajava.bootnuevo.repositorios;

import java.util.List;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;

public interface CapituloRepository {

	public List<Capitulo> buscarTodos(); 
	public void borrar(Capitulo capitulo);
	public void insertar(Capitulo capitulo);
}
