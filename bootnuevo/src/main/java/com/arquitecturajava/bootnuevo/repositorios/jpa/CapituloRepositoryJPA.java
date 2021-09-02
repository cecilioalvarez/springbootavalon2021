package com.arquitecturajava.bootnuevo.repositorios.jpa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.repositorios.CapituloRepository;
//Aqui implementamos la interfaz, pq JPA es muy compacto
@Repository
@Qualifier("jpa")
public class CapituloRepositoryJPA  extends GenericRepositoryJPA<Capitulo> implements CapituloRepository {


}
