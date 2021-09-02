//package com.arquitecturajava.bootnuevo.repositorios.jdbc;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.arquitecturajava.bootnuevo.negocio.Capitulo;
//import com.arquitecturajava.bootnuevo.negocio.Libro;
//import com.arquitecturajava.bootnuevo.repositorios.LibroRepository;
//import com.arquitecturajava.bootnuevo.repositorios.jdbc.mappers.CapituloMapper;
//import com.arquitecturajava.bootnuevo.repositorios.jdbc.mappers.LibroCapitulosExtractor;
//import com.arquitecturajava.bootnuevo.repositorios.jdbc.mappers.LibroMapper;
//import com.arquitecturajava.bootnuevo.repositorios.jpa.GenericRepositoryJPA;
//
//@Repository
//@Qualifier("jdbc")
//public class LibroRepositoryJDBC implements LibroRepository {
//
//	private JdbcTemplate plantilla;
//
//	public LibroRepositoryJDBC(JdbcTemplate plantilla) {
//		super();
//
//		this.plantilla = plantilla;
//	}
//
//	final static String CONSULTA_INSERTAR = "insert into Libros (isbn,titulo,autor) values (?,?,?)";
//	final static String CONSULTA_BORRAR = "delete from Libros  where isbn =?";
//	final static String CONSULTA_BUSCAR_TODOS = "select * from Libros";
//	final static String CONSULTA_BUSCAR_TODOS_CAPITULOS_LIBRO = "select * from Capitulos where libros_isbn=?";
//	final static String CONSULTA_BUSCAR_TODOS_CON_CAPITULOS = "select Libros.isbn as isbn, Libros.titulo as titulo, Libros.autor as autor, Capitulos.titulo as tituloCapitulo, Capitulos.paginas as paginas from Libros,Capitulos where Libros.isbn= Capitulos.libros_isbn";
//	final static String CONSULTA_BUSCAR_UNO = "select * from Libros where isbn=?";
//	final static String CONSULTA_BUSCAR_TITULO_AUTOR = "select * from Libros where titulo=? and autor=?";
//	final static String CONSULTA_ACTUALIZAR = "update Libros set titulo=? , autor=? where isbn=?";
//
//	@Transactional
//	public void actualizar(Libro libro) {
//
//		plantilla.update(CONSULTA_ACTUALIZAR, libro.getTitulo(), libro.getAutor(), libro.getIsbn());
//
//	}
//
//	@Transactional
//	public void insertar(Libro libro) {
//
//		plantilla.update(CONSULTA_INSERTAR, libro.getIsbn(), libro.getTitulo(), libro.getAutor());
//
//	}
//	@Transactional
//	public void borrar(Libro libro) {
//
//		plantilla.update(CONSULTA_BORRAR, libro.getIsbn());
//
//	}
//	// porque vamos a buscar todos los libros
//	// no tiene mucho sentido instanciar un libro
//	// para luego más adelante buscar todos
//
//	public List<Libro> buscarTodos() {
//
//		return plantilla.query(CONSULTA_BUSCAR_TODOS, new LibroMapper());
//
//	}
//
//	public List<Libro> buscarTituloyAutor(String titulo, String autor) {
//
//		return plantilla.query(CONSULTA_BUSCAR_TITULO_AUTOR, new LibroMapper(), titulo, autor);
//
//	}
//
//	public Libro buscarUno(String isbn) {
//
//		return plantilla.queryForObject(CONSULTA_BUSCAR_UNO, new LibroMapper(), isbn);
//
//	}
//
//	@Override
//	public List<Libro> buscarTodosConCapitulos() {
//
//		return plantilla.query(CONSULTA_BUSCAR_TODOS_CON_CAPITULOS, new LibroCapitulosExtractor());
//
//	}
//
//	@Override
//	public List<Capitulo> buscarTodosCapitulos(Libro libro) {
//
//		return plantilla.query(CONSULTA_BUSCAR_TODOS_CAPITULOS_LIBRO, new CapituloMapper(), libro.getIsbn());
//
//	}
//
//	@Override
//	public Optional<Libro> buscarUno(Object id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
