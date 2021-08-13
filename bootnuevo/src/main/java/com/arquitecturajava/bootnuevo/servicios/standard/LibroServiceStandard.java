package com.arquitecturajava.bootnuevo.servicios.standard;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;
import com.arquitecturajava.bootnuevo.repositorios.CapituloRepository;
import com.arquitecturajava.bootnuevo.repositorios.LibroRepository;
import com.arquitecturajava.bootnuevo.servicios.LibroService;
@Service
public class LibroServiceStandard implements LibroService  {

	private LibroRepository repositorio;
	private CapituloRepository repositorioCapitulo;

	
	public LibroServiceStandard(LibroRepository repositorio,CapituloRepository repositorioCapitulo) {
		super();
		this.repositorio = repositorio;
		this.repositorioCapitulo = repositorioCapitulo;
	}

	@Transactional
	public void actualizar(Libro libro) {
		repositorio.actualizar(libro);
	}

	@Transactional
	public void insertar(Libro libro) {
		repositorio.insertar(libro);
	}
	@Transactional
	public void borrar(Libro libro) {
		repositorio.borrar(libro);
	}

	public List<Libro> buscarTodos() {
		return repositorio.buscarTodos();
	}

	public List<Libro> buscarTodosConCapitulos() {
		return repositorio.buscarTodosConCapitulos();
	}

	public List<Libro> buscarTituloyAutor(String titulo, String autor) {
		return repositorio.buscarTituloyAutor(titulo, autor);
	}

	public Libro buscarUno(String isbn) {
		return repositorio.buscarUno(isbn);
	}

	@Override
	public List<Capitulo> buscarTodosLosCapitulos() {
		// TODO Auto-generated method stub
		return repositorioCapitulo.buscarTodos();
	}

	@Override
	public void borrarCapitulo(Capitulo capitulo) {
		repositorioCapitulo.borrar(capitulo);
		
	}

	@Override
	public void insertarCapitulo(Capitulo capitulo) {
		
		repositorioCapitulo.insertar(capitulo);
		
	}

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
		
		return repositorio.buscarTodosCapitulos(libro);
	}

	@Override
	@Transactional
	public void insertarVariosLibros(Libro... libros) {
		
		for (Libro l : libros) {
			repositorio.insertar(l);
		}
		
	}
	
	
}
