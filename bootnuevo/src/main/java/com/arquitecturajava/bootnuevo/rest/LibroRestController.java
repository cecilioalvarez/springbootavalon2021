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
//RestController devuelve los datos en formato json
@RequestMapping("/webapi/libros")
public class LibroRestController {
	
	private LibroService servicio;

	public LibroRestController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}
	
	@GetMapping
	public List<Libro> buscarTodos(){
		return servicio.buscarTodos();
	}
	
	@DeleteMapping("/{isbn}")
	public void borrar(@PathVariable String isbn) {
		servicio.borrar(new Libro(isbn));
	}

	@PutMapping("/{isbn}")
	public void actualizar(@RequestBody Libro libro,@PathVariable String isbn) {
		Optional<Libro> libroModificado = servicio.buscarUno(isbn);
		
		if (libroModificado.isPresent()) {
			libroModificado.get().setTitulo(libro.getTitulo());
			libroModificado.get().setAutor(libro.getAutor());
			servicio.actualizar(libroModificado.get());
		}
		
	}

	@PostMapping
	public void insertar(@RequestBody Libro libro) {
		servicio.insertar(libro);
	}

	@GetMapping("/{isbn}")
	public Optional<Libro> buscarUno(@PathVariable String isbn) {
		return servicio.buscarUno(isbn);
	}

	@GetMapping("/{isbn}/capitulos")
	public List<Capitulo> buscarTodosCapitulos(@PathVariable String isbn) {
		return servicio.buscarTodosCapitulos(new Libro (isbn));
	}
	
	
	
	
}
