package com.arquitecturajava.bootnuevo.negocio;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="editoriales")
public class Editorial {
	@Id
	private String nombre;
	private String categoria;
	@JsonIgnore
	@OneToOne(mappedBy = "editorial")
	private Libro libro;
	
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public Editorial() {}
	public Editorial(String nombre, String categoria) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
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
