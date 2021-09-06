package com.arquitecturajava.bootnuevo.dto;

import com.arquitecturajava.bootnuevo.negocio.Libro;

public class LibroDTO {
	private String isbn;
	private String titulo;
	private String autor;
	
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
	public LibroDTO(Libro libro) {
		super();
		this.isbn = libro.getIsbn();
		this.titulo = libro.getTitulo();
		this.autor = libro.getAutor();
	}
	public LibroDTO() {
		super();
	}
	
}
