package com.arquitecturajava.bootnuevo.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitecturajava.bootnuevo.dto.LibroDTO;
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
/*
	@PostMapping
	public void insertar(@RequestBody Libro libro) {
		servicio.insertar(libro);
	}*/
	
	//usando dto
	@PostMapping
	public void insertar(@RequestBody LibroDTO libroDTO) {
		servicio.insertar(new Libro(libroDTO.getIsbn(),libroDTO.getTitulo(),libroDTO.getAutor()));
	}
	
	/*
	 * @PutMapping("{isbn}") public void actualizar(@RequestBody Libro
	 * libro, @PathVariable String isbn) { Optional<Libro> libroActual=
	 * servicio.buscarUno(isbn); if(libroActual.isPresent()) { Libro libroNormal =
	 * libroActual.get(); libroNormal.setTitulo(libro.getTitulo());
	 * libroNormal.setAutor(libro.getAutor()); servicio.actualizar(libroNormal); }
	 * /*Libro libroActual = servicio.buscarUno(isbn);
	 * libroActual.setTitulo(libro.getTitulo());
	 * libroActual.setAutor(libro.getAutor()); servicio.actualizar(libro);
	 */
	/* } */

	//Usando DTO
	@PutMapping("{isbn}")
	public void actualizar(@RequestBody LibroDTO libroDTO, @PathVariable String isbn) {
		Optional<Libro> libroActual= servicio.buscarUno(isbn);
		if(libroActual.isPresent()) {
			Libro libroNormal = libroActual.get();
			libroNormal.setTitulo(libroDTO.getTitulo());
			libroNormal.setAutor(libroDTO.getAutor());
			servicio.actualizar(libroNormal);
		}
	}

	/*
	@GetMapping
	public List<Libro> buscarTodos() {
		return servicio.buscarTodos();
	}*/
	
	//Con libroDTO
	@GetMapping
	public List<LibroDTO> buscarTodos() {
		
		//Nos devuelve una lista de DTO
		return servicio.buscarTodos().stream().map(LibroDTO::new).collect(Collectors.toList());
		
	}
	
	
	/*
	@GetMapping("{isbn}")
	public Optional<Libro> buscarUno(@PathVariable String isbn) {
		return servicio.buscarUno(isbn);
	}*/
	
	//Con DTO
	@GetMapping("{isbn}")
	public Optional<LibroDTO> buscarUno(@PathVariable String isbn) {
		
		Optional<Libro> oLibro = servicio.buscarUno(isbn);
		if(oLibro.isPresent()) {
			return Optional.of(new LibroDTO(oLibro.get()));
		}
		
		return Optional.empty();
		
		//Esto seria lo mismo pero en menos lineas.
		//Busca un valor optional y lo convierte en un DTO.
		//return servicio.buscarUno(isbn).map(LibroDTO::new);
	}

	@GetMapping("{isbn}/capitulos")
	public List<Capitulo> buscarTodosCapitulos(@PathVariable String isbn) {
		return servicio.buscarTodosCapitulos(new Libro(isbn));
	}

}
