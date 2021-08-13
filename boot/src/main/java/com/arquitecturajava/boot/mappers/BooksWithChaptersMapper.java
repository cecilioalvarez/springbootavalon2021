package com.arquitecturajava.boot.mappers;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class BooksWithChaptersMapper implements ResultSetExtractor<List<Book>> {

    @Override
    public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
        final List<Book> BOOKS = new ArrayList<>();
        while (rs.next()) {
            Book book = new Book(rs.getString("pk_isbn"));
            if (!BOOKS.contains(book)) {
                book.setTitle(rs.getString("title"));
                book.setFk_author(new Author(rs.getString("pk_id"), rs.getString("name"), rs.getInt("age")));
                BOOKS.add(book);
            } else {
                book = BOOKS.get(BOOKS.size() - 1);
            }
            if (rs.getString("pk_title") != null) {
                book.addChapter(new Chapter(rs.getString("pk_title"), rs.getInt("pages"), book));
            }
        }
        return BOOKS;
    }
}