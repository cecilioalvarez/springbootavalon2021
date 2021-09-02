package com.arquitecturajava.bootnuevo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;

public interface CapituloRepository extends JpaRepository<Capitulo, String> {

}
