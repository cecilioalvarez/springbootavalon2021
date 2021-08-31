package com.arquitecturajava.bootnuevo.negocio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="editoriales")
public class Editorial {
	
	@Id
	private String nombre;
	private String categoria;
	
	@OneToOne(mappedBy="editorial")
	private Libro libro;
	
	public Editorial(String nombre, String categoria, Libro libro) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.libro = libro;
	}
	
	public Editorial() {
		super();
	}
	
	public Libro getLibro() {
		return libro;
	}
	
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
