package com.arquitecturajava.bootnuevo.repositorios.jdbc.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.arquitecturajava.bootnuevo.negocio.Capitulo;
import com.arquitecturajava.bootnuevo.negocio.Libro;

public class LibroCapitulosExtractor implements ResultSetExtractor<List<Libro>> {

	@Override
	public List<Libro> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<Libro> listaLibros = new ArrayList<Libro>();

		while (rs.next()) {

			Libro l = new Libro(rs.getString("isbn"), rs.getString("titulo"), rs.getString("autor"));

			if (!listaLibros.contains(l)) {

				listaLibros.add(l);
				l.addCapitulo(new Capitulo(rs.getString("tituloCapitulo"), rs.getInt("paginas"), l));
			} else {
				listaLibros.get(listaLibros.size() - 1)
						.addCapitulo(new Capitulo(rs.getString("tituloCapitulo"), rs.getInt("paginas"), l));
			}

			
		}
		return listaLibros;
	}
}
