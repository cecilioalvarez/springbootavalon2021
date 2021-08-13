package com.arquitecturajava.boot.mappers;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ChapterMapper implements RowMapper<Chapter>{

    @Override
    public Chapter mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author(rs.getString("pk_id"), rs.getString("name"), rs.getInt("age"));
        Book book = new Book(rs.getString("pk_isbn"), rs.getString("title"), author);
        return new Chapter(rs.getString("pk_title"), rs.getInt("pages"), book);
    }
}