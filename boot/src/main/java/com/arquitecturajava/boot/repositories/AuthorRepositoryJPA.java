package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Author;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public class AuthorRepositoryJPA extends GenericRepositoryJPA<Author> implements AuthorRepository {

    @Override
    public int updatePk_id(Author author, String pk_id) {
        final String STRING_QUERY = "UPDATE Author a "
                + "SET a.pk_id = :new_pk_id "
                + "WHERE a.pk_id = :old_pk_id";
        final TypedQuery<Author> QUERY = this.entityManager.createQuery(STRING_QUERY, Author.class);
        QUERY.setParameter("new_pk_id", pk_id);
        QUERY.setParameter("old_pk_id", author.getPk_id());
        return QUERY.executeUpdate();
    }

    @Override
    public int updateName(Author author, String name) {
        final String STRING_QUERY = "UPDATE Author a "
                + "SET a.name = :name "
                + "WHERE a.pk_id = :pk_id";
        final TypedQuery<Author> QUERY = this.entityManager.createQuery(STRING_QUERY, Author.class);
        QUERY.setParameter("name", name);
        QUERY.setParameter("pk_id", author.getPk_id());
        return QUERY.executeUpdate();
    }

    @Override
    public int updateAge(Author author, int age) {
        final String STRING_QUERY = "UPDATE Author a "
                + "SET a.age = :age "
                + "WHERE a.pk_id = :pk_id";
        final TypedQuery<Author> QUERY = this.entityManager.createQuery(STRING_QUERY, Author.class);
        QUERY.setParameter("age", age);
        QUERY.setParameter("pk_id", author.getPk_id());
        return QUERY.executeUpdate();
    }
}