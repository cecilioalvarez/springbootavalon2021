package com.arquitecturajava.bootnuevo.repositorios;

import java.util.List;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

public interface CapituloRepository  extends GenericRepository<Capitulo>{

	public List<Capitulo> buscarTodos(); 
	public void borrar(Capitulo capitulo);
	public void insertar(Capitulo capitulo);
}
