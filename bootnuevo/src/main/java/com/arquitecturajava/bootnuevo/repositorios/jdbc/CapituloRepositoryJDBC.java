package com.arquitecturajava.bootnuevo.repositorios.jdbc;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.repositorios.CapituloRepository;
import com.arquitecturajava.bootnuevo.repositorios.jdbc.mappers.CapituloMapper;
@Component
public class CapituloRepositoryJDBC implements CapituloRepository {

	private JdbcTemplate plantilla;
	
	
	public CapituloRepositoryJDBC(JdbcTemplate plantilla) {
		super();
		
		this.plantilla=plantilla;
	}


	final static String CONSULTA_BUSCAR_TODOS = "select * from Capitulos";
	final static String CONSULTA_BORRAR = "delete from Capitulos where titulo=?";
	final static String CONSULTA_INSERTAR = "insert into Capitulos (titulo,paginas,libros_isbn) values (?,?,?)";
	
	@Override
	public List<Capitulo> buscarTodos() {
		
	
				return plantilla.query(CONSULTA_BUSCAR_TODOS,new CapituloMapper());
	}
	@Transactional
	public void borrar(Capitulo capitulo) {
		
		
		plantilla.update(CONSULTA_BORRAR,capitulo.getTitulo());
	}
	
	@Transactional
	public void insertar(Capitulo capitulo) {

		plantilla.update(CONSULTA_INSERTAR,capitulo.getTitulo(),capitulo.getPaginas(),capitulo.getLibro().getIsbn());

	}

}
