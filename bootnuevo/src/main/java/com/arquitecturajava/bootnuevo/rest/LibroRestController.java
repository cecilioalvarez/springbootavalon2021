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

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;
import com.arquitecturajava.bootnuevo.rest.dto.LibroDTO;
import com.arquitecturajava.bootnuevo.servicios.LibroService;
import com.fasterxml.jackson.datatype.jdk8.OptionalDoubleSerializer;

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
	public List<LibroDTO> buscarTodos(){
		//return servicio.buscarTodos();
		return servicio.buscarTodos().stream().map(LibroDTO::new).collect(Collectors.toList());
	}
	
	@DeleteMapping("/{isbn}")
	public void borrar(@PathVariable String isbn) {
		servicio.borrar(new Libro(isbn));
	}

	@PutMapping("/{isbn}")
	public void actualizar(@RequestBody LibroDTO libroDTO,@PathVariable String isbn) {
		Optional<Libro> libroModificado = servicio.buscarUno(isbn);
		
		if (libroModificado.isPresent()) {
			libroModificado.get().setTitulo(libroDTO.getTitulo());
			libroModificado.get().setAutor(libroDTO.getAutor());
			servicio.actualizar(libroModificado.get());
		}
		
	}

	@PostMapping
	public void insertar(@RequestBody LibroDTO libroDTO) {
		servicio.insertar(new Libro(libroDTO.getIsbn(),libroDTO.getTitulo(),libroDTO.getAutor()));
	}

	@GetMapping("/{isbn}")
	public Optional<LibroDTO> buscarUno(@PathVariable String isbn) {
		//Opcion 1
		Optional<Libro> oLibro = servicio.buscarUno(isbn);
		if (oLibro.isPresent()) {
			return Optional.of(new LibroDTO(oLibro.get()));
		}
		return Optional.empty();
		
		//Opcion 2
		//return servicio.buscarUno(isbn).map(LibroDTO::new);
	}

	@GetMapping("/{isbn}/capitulos")
	public List<Capitulo> buscarTodosCapitulos(@PathVariable String isbn) {
		return servicio.buscarTodosCapitulos(new Libro (isbn));
	}
	
	
	
	
}
