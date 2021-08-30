package com.arquitecturajava.bootnuevo.repositorios.jjpa;

import java.util.List;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;
import com.arquitecturajava.bootnuevo.repositorios.LibroRepository;

public class LibroRepositoryJPA implements LibroRepository {

	@Override
	public void actualizar(Libro libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertar(Libro libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Libro libro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Libro> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> buscarTodosConCapitulos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> buscarTituloyAutor(String titulo, String autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro buscarUno(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
		// TODO Auto-generated method stub
		return null;
	}

}
