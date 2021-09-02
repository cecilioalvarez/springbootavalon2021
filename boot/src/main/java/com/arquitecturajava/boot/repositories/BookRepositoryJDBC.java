package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.mappers.BookMapper;
import com.arquitecturajava.boot.mappers.BookWithChaptersMapper;
import com.arquitecturajava.boot.mappers.BooksWithChaptersMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("jdbc")
public class BookRepositoryJDBC implements BookRepository {
    
    @Autowired
    private JdbcTemplate template;
    
    @Override
    public Optional<Book> select(Object pk_isbn) {
        final String QUERY = "SELECT * FROM book b "
                + "JOIN author a ON b.fk_author = a.pk_id "
                + "WHERE b.pk_isbn = ?";
        Object[] params = {(String) pk_isbn};
        return Optional.ofNullable(this.template.queryForObject(QUERY, params, new BookMapper()));
    }

    @Override
    public List<Book> selectAll() {
        final String QUERY = "SELECT * FROM book b "
                + "JOIN author a ON b.fk_author = a.pk_id";
        return this.template.query(QUERY, new BookMapper());
    }

    @Override
    public Book selectAllWithChapters(Book book) {
        final String QUERY = "SELECT * FROM book b "
                + "JOIN author a ON b.fk_author = a.pk_id "
                + "LEFT JOIN chapter c ON b.pk_isbn = c.pk_fk_book "
                + "WHERE b.pk_isbn = ?";
        Object[] params = {book.getPk_isbn()};
        return this.template.query(QUERY, params, new BookWithChaptersMapper());
    }
    
    public List<Book> selectBooksWithChapters() {
        final String QUERY = "SELECT * FROM book b "
                + "JOIN author a ON b.fk_author = a.pk_id "
                + "LEFT JOIN chapter c ON b.pk_isbn = c.pk_fk_book";
        return this.template.query(QUERY, new BooksWithChaptersMapper());
    }

    @Override
    public List<Book> select(Author fk_author) {
        final String QUERY = "SELECT * FROM book b "
                + "JOIN author a ON b.fk_author = a.pk_id "
                + "LEFT JOIN chapter c ON b.pk_isbn = c.pk_fk_book "
                + "WHERE a.pk_id = ?";
        Object[] params = {fk_author.getPk_id()};
        return this.template.query(QUERY, params, new BooksWithChaptersMapper());
    }

    @Transactional
    @Override
    public void insert(Book book) {
        final String QUERY = "INSERT INTO book (pk_isbn, title, fk_author) VALUES (?, ?, ?)";
        this.template.update(QUERY, book.getPk_isbn(), book.getTitle(), book.getFk_author().getPk_id());
    }

    @Transactional
    @Override
    public void delete(Book book) {
        final String QUERY = "DELETE FROM book WHERE pk_isbn = ?";
        this.template.update(QUERY, book.getPk_isbn());
    }

    @Transactional
    @Override
    public int deleteBooks(Author fk_author) {
        final String QUERY = "DELETE FROM book WHERE fk_author = ?";
        return this.template.update(QUERY, fk_author.getPk_id());
    }

    @Transactional
    @Override
    public void update(Book book) {
        final String QUERY = "UPDATE book SET title = ?, fk_author = ? WHERE pk_isbn = ?";
        this.template.update(QUERY, book.getTitle(), book.getFk_author().getPk_id(), book.getPk_isbn());
    }

    @Transactional
    @Override
    public int updatePk_isbn(Book book, String pk_isbn) {
        final String QUERY = "UPDATE book SET pk_isbn = ? WHERE pk_isbn = ?";
        return this.template.update(QUERY, pk_isbn, book.getPk_isbn());
    }

    @Transactional
    @Override
    public int updateTitle(Book book, String title) {
        final String QUERY = "UPDATE book SET title = ? WHERE pk_isbn = ?";
        return this.template.update(QUERY, title, book.getPk_isbn());
    }

    @Transactional
    @Override
    public int updateAuthor(Book book, Author author) {
        final String QUERY = "UPDATE book SET fk_author = ? WHERE pk_isbn = ?";
        return this.template.update(QUERY, author.getPk_id(), book.getPk_isbn());
    }
}