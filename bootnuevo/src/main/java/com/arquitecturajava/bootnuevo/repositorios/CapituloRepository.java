package com.arquitecturajava.bootnuevo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;

//Se pasa clase y clave primaria en el JpaRepository
public interface CapituloRepository  extends JpaRepository<Capitulo,String>{

	
}
