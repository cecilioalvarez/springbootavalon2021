package com.arquitecturajava.boot.mappers;

import com.arquitecturajava.boot.business.Author;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AuthorMapper implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Author(rs.getString("pk_id"), rs.getString("name"), rs.getInt("age"));
    }
}