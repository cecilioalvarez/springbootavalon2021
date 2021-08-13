package com.arquitecturajava.boot.mappers;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class BookWithChaptersMapper implements ResultSetExtractor<Book> {

    @Override
    public Book extractData(ResultSet rs) throws SQLException, DataAccessException {
        Book searchedBook = null;
        while (rs.next()) {
            if (searchedBook == null) {
                Author author = new Author(rs.getString("pk_id"), rs.getString("name"), rs.getInt("age"));
                searchedBook = new Book(rs.getString("pk_isbn"), rs.getString("title"), author);
            }
            if (rs.getString("pk_title") != null) {
                searchedBook.addChapter(new Chapter(rs.getString("pk_title"), rs.getInt("pages"), searchedBook));
            }
        }
        return searchedBook;
    }
}