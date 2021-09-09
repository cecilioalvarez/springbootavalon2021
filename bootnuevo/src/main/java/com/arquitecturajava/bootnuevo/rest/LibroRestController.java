package com.arquitecturajava.bootnuevo.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arquitecturajava.bootnuevo.dto.LibroDTO;
import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;
import com.arquitecturajava.bootnuevo.servicios.LibroService;

@RestController
@RequestMapping("/webapi/libros")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class LibroRestController {
	
	private LibroService servicio;
	@DeleteMapping("{isbn}")
	public void borrar(@PathVariable String isbn) {
		servicio.borrar(new Libro(isbn));
	}
	
	@PutMapping("{isbn}")
	public void actualizar(@RequestBody LibroDTO libroDTO, @PathVariable String isbn) {
		
		Optional<Libro> libroactual=servicio.buscarUno(isbn);
		if (libroactual.isPresent()) {
			Libro libroNormal= libroactual.get();
			libroNormal.setTitulo(libroDTO.getTitulo());
			libroNormal.setAutor(libroDTO.getAutor());
			servicio.actualizar(libroNormal);
		}

	
		
	}
	@PostMapping
	public void insertar(@RequestBody LibroDTO libroDTO) {
		servicio.insertar(new Libro(libroDTO.getIsbn(),libroDTO.getTitulo(),libroDTO.getAutor()));
	}


	@GetMapping("/{isbn}")
	public Optional<LibroDTO> buscarUno(@PathVariable String isbn) {
		
		
		Optional<Libro> oLibro= servicio.buscarUno(isbn);
		if (oLibro.isPresent()) {
			return  Optional.of(new LibroDTO(oLibro.get()));
		}
		
		return Optional.empty();
		
		//return servicio.buscarUno(isbn).map(LibroDTO::new);
		
	}

	public LibroRestController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}
	@GetMapping
	public List<LibroDTO> buscarTodos() {
		
	return	servicio.buscarTodos().stream().map(LibroDTO::new).collect(Collectors.toList());
		
		
	}
	@GetMapping("{isbn}/capitulos")
	public List<Capitulo> buscarTodosCapitulos(@PathVariable String isbn) {
		return servicio.buscarTodosCapitulos(new Libro(isbn));
	}

	@GetMapping(params = "titulo")
	public List<Libro> buscarLibroPorTituloComenzando(@RequestParam (required = true) String titulo) {
		return servicio.buscarLibroPorTituloComenzando(titulo);
	}
	
	
	
}
