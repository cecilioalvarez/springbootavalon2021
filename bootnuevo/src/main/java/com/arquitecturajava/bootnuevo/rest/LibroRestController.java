package com.arquitecturajava.bootnuevo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.arquitecturajava.bootnuevo.negocio.Libro;
import com.arquitecturajava.bootnuevo.servicios.LibroService;

@RestController
public class LibroRestController {
	
	private LibroService servicio;

	public LibroRestController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}

	public List<Libro> buscarTodos() {
		
		return servicio.buscarTodos();
	}
}
