package com.arquitecturajava.bootnuevo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping
	public List<Libro> buscarTodos() {
		
		return servicio.buscarTodos();
	}
}
