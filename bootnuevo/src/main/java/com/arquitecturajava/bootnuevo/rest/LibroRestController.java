package com.arquitecturajava.bootnuevo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;
import com.arquitecturajava.bootnuevo.servicios.LibroService;

@RestController
@RequestMapping("/webapi/libros")
public class LibroRestController {
	private LibroService servicio;

	public LibroRestController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}
	
	@DeleteMapping("{isbn}")
	public void borrar(@PathVariable String isbn) {
		servicio.borrar(new Libro(isbn));
	}
	
	@PostMapping
	public void insertar (@RequestBody Libro libro) {
		servicio.insertar(libro);
	}
	
	@PutMapping("{isbn}")
	public void actualizar(@RequestBody Libro libro, @PathVariable String isbn) {
		Optional<Libro> libroActual= servicio.buscarUno(isbn);
		if(libroActual.isPresent()) {
			Libro libroNormal = libroActual.get();
			libroNormal.setTitulo(libro.getTitulo());
			libroNormal.setAutor(libro.getAutor());
			servicio.actualizar(libroNormal);
		}
		/*Libro libroActual = servicio.buscarUno(isbn);
		libroActual.setTitulo(libro.getTitulo());
		libroActual.setAutor(libro.getAutor());
		servicio.actualizar(libro);*/
	}
	
	@GetMapping
	public List<Libro> buscarTodos(){
		return servicio.buscarTodos();
	}
	
	@GetMapping("{isbn}")
	public Optional<Libro> buscarUno(@PathVariable String isbn) {
		return servicio.buscarUno(isbn);
	}

	@GetMapping("{isbn}/capitulos")
	public List<Capitulo> buscarTodosCapitulos(@PathVariable String isbn) {
		return servicio.buscarTodosCapitulos(new Libro(isbn));
	}
	
	
	
}
