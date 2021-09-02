package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.mappers.AuthorMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("jdbc")
public class AuthorRepositoryJDBC implements AuthorRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public Author select(Object pk_id) {
        final String QUERY = "SELECT * FROM author WHERE pk_id = ?";
        Object[] params = {(String) pk_id};
        return this.template.queryForObject(QUERY, params, new AuthorMapper());
    }

    @Override
    public List<Author> selectAll() {
        final String QUERY = "SELECT * FROM author";
        return this.template.query(QUERY, new AuthorMapper());
    }
    
    @Transactional
    @Override
    public void insert(Author author) {
        final String QUERY = "INSERT INTO author (pk_id, name, age) VALUES (?, ?, ?)";
        this.template.update(QUERY, author.getPk_id(), author.getName(), author.getAge());
    }

    @Transactional
    @Override
    public void delete(Author author) {
        final String QUERY = "DELETE FROM author WHERE pk_id = ?";
        this.template.update(QUERY, author.getPk_id());
    }

    @Transactional
    @Override
    public void update(Author author) {
        final String QUERY = "UPDATE author SET name = ?, age = ? WHERE pk_id = ?";
        this.template.update(QUERY, author.getName(), author.getAge(), author.getPk_id());
    }

    @Transactional
    @Override
    public int updatePk_id(Author author, String pk_id) {
        final String QUERY = "UPDATE author SET pk_id = ? WHERE pk_id = ?";
        return this.template.update(QUERY, pk_id, author.getPk_id());
    }

    @Transactional
    @Override
    public int updateName(Author author, String name) {
        final String QUERY = "UPDATE author SET name = ? WHERE pk_id = ?";
        return this.template.update(QUERY, name, author.getPk_id());
    }

    @Transactional
    @Override
    public int updateAge(Author author, int age) {
        final String QUERY = "UPDATE author SET age = ? WHERE pk_id = ?";
        return this.template.update(QUERY, age, author.getPk_id());
    }
}