package com.arquitecturajava.bootnuevo.rest.dto;

import com.arquitecturajava.bootnuevo.negocio.Libro;

public class LibroDTO {

	private  String isbn;
	private  String titulo;
	private  String autor;
	
	public LibroDTO(Libro libro) {
		super();
		this.isbn = libro.getIsbn();
		this.titulo = libro.getTitulo();
		this.autor = libro.getAutor();
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	
}
