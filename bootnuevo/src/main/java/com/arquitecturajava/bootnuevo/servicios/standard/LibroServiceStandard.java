package com.arquitecturajava.bootnuevo.servicios.standard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
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

	//@Qualifier("jpa") no hace falta en el constructor porque no tengo otros
	public LibroServiceStandard(LibroRepository repositorio,CapituloRepository repositorioCapitulo) {
		super();
		this.repositorio = repositorio;
		this.repositorioCapitulo = repositorioCapitulo;
	}

	@Transactional
	public void actualizar(Libro libro) {
		repositorio.save(libro);
	}

	@Transactional
	public void insertar(Libro libro) {
		repositorio.save(libro);
	}
	@Transactional
	public void borrar(Libro libro) {
		repositorio.delete(libro);
	}

	public List<Libro> buscarTodos() {
		return repositorio.findAll();
	}

	public List<Libro> buscarTodosConCapitulos() {
		return repositorio.buscarTodosConCapitulos();
		//return null;
	}

	public List<Libro> buscarTituloyAutor(String titulo, String autor) {
		return repositorio.findByTituloAndAutor(titulo, autor);
		//return null;
	}

	public Optional<Libro> buscarUno(String isbn) {
		return repositorio.findById(isbn);
	}

	@Override
	public List<Capitulo> buscarTodosLosCapitulos() {
		// TODO Auto-generated method stub
		return repositorioCapitulo.findAll();
	}

	@Override
	public void borrarCapitulo(Capitulo capitulo) {
		repositorioCapitulo.delete(capitulo);
		
	}

	@Override
	public void insertarCapitulo(Capitulo capitulo) {
		
		repositorioCapitulo.save(capitulo);
		
	}

	@Override
	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
		//Antes
		//return repositorio.buscarTodosCapitulos(libro);
		return repositorio.buscarTodosCapitulos(libro.getIsbn());
		//return null;
	}

	@Override
	@Transactional
	public void insertarVariosLibros(Libro... libros) {
		
		for (Libro l : libros) {
			repositorio.save(l);
		}
		
	}
	
	
}
