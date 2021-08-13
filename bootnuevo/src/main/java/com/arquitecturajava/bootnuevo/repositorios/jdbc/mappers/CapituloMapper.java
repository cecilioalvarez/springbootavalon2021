package com.arquitecturajava.bootnuevo.repositorios.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

public class CapituloMapper implements RowMapper<Capitulo> {

	@Override
	public Capitulo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Capitulo(rs.getString("titulo"),rs.getInt("paginas"),new Libro(rs.getString("libros_isbn")));
	}

}
