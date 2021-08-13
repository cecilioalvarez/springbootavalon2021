package com.arquitecturajava.bootnuevo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquitecturajava.bootnuevo.servicios.LibroService;
//Transformar la info a JSON
@RestController
@RequestMapping("/webapi/libros")
public class CapituloRestController {

	private LibroService servicio;

	public CapituloRestController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}

	
}
