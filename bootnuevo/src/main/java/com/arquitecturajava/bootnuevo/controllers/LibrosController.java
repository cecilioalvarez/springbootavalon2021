package com.arquitecturajava.bootnuevo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arquitecturajava.bootnuevo.negocio.Libro;
import com.arquitecturajava.bootnuevo.servicios.LibroService;

@Controller
@RequestMapping("/libros")
public class LibrosController {

	private LibroService servicio;
	
	public LibrosController(LibroService servicio) {
		super();
		this.servicio = servicio;
	}

	@RequestMapping("/lista")
	public String lista(Model modelo) {
		modelo.addAttribute("libros",servicio.buscarTodos());
		return "listalibros";
	}
	@RequestMapping("/detalle")
	public String detallelibro(Model modelo,String isbn) {
		
		modelo.addAttribute("libro",servicio.buscarUno(isbn));
		return "detallelibro";
	}
	@RequestMapping("/borrar")
	public String borrar(Model modelo,String isbn) {
		servicio.borrar(new Libro(isbn));
		return "redirect:lista";
	}
	@RequestMapping("/nuevo")
	public String nuevo(Model modelo) {
		return "formulariolibro";
	}
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String insertar(Model modelo,Libro libro) {
		servicio.insertar(libro);
		return  "redirect:lista";
	}
	
	@RequestMapping("/editar")
	public String formularioEditar(Model modelo,String isbn) {
			
		modelo.addAttribute("libro",servicio.buscarUno(isbn));
		return "formularioeditar";
	}
	
	
	@RequestMapping(value="/salvar",method=RequestMethod.POST)
	public String salvarLibro(Model modelo,Libro libro) {
		
		servicio.actualizar(libro);
		//aqui tenia buscar libros un addattribute
		return  "redirect:lista";
	}
	
	//////////////////////////////
	
	@RequestMapping("/{isbn}/capitulos")
	public String verCapitulos(Model modelo,@PathVariable String isbn) {
		
		modelo.addAttribute("isbn",isbn);
		modelo.addAttribute("capitulos",servicio.buscarTodosCapitulos(new Libro(isbn)));
		return "listacapitulos";
	}
	
	
	
}
