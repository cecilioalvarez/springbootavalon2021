package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public class BookRepositoryJPA implements BookRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book selectBook(Book book) {
        return this.entityManager.find(Book.class, book.getPk_isbn());
    }

    @Override
    public Book selectBookWithChapters(Book book) {
        final TypedQuery<Book> QUERY = this.entityManager.createNamedQuery("Book.selectBookWithChapters", Book.class);
        QUERY.setParameter("pk_isbn", book.getPk_isbn());
        return QUERY.getSingleResult();
    }

    @Override
    public List<Book> selectBooks() {
        return this.entityManager.createNamedQuery("Book.selectAll", Book.class).getResultList();
    }

    @Override
    public List<Book> selectBooksWithChapters() {
        return this.entityManager.createNamedQuery("Book.selectAllWithChapters", Book.class).getResultList();
    }

    @Override
    public List<Book> select(Author fk_author) {
        final TypedQuery<Book> QUERY = this.entityManager.createNamedQuery("Book.selectAllByAuthor", Book.class);
        QUERY.setParameter("pk_id", fk_author.getPk_id());
        return QUERY.getResultList();
    }

    @Override
    public void insert(Book book) {
        this.entityManager.persist(book);
    }

    @Override
    public void delete(Book book) {
        this.entityManager.remove(this.entityManager.merge(book));
    }

    @Override
    public int deleteBooks(Author fk_author) {
        final String STRING_QUERY = "DELETE b "
                + "FROM Book b "
                + "WHERE b.fk_author.pk_id = :pk_id";
        final TypedQuery<Book> QUERY = this.entityManager.createQuery(STRING_QUERY, Book.class);
        QUERY.setParameter("pk_id", fk_author.getPk_id());
        return QUERY.executeUpdate();
    }

    @Override
    public void update(Book book) {
        this.entityManager.merge(book);
    }

    @Override
    public int updatePk_isbn(Book book, String pk_isbn) {
        final String STRING_QUERY = "UPDATE Book b "
                + "SET b.pk_isbn = :new_pk_isbn "
                + "WHERE b.pk_isbn = :old_pk_isbn";
        final TypedQuery<Book> QUERY = this.entityManager.createQuery(STRING_QUERY, Book.class);
        QUERY.setParameter("new_pk_isbn", pk_isbn);
        QUERY.setParameter("old_pk_isbn", book.getPk_isbn());
        return QUERY.executeUpdate();
    }

    @Override
    public int updateTitle(Book book, String title) {
        final String STRING_QUERY = "UPDATE Book b "
                + "SET b.title = :title "
                + "WHERE b.pk_isbn = :pk_isbn";
        final TypedQuery<Book> QUERY = this.entityManager.createQuery(STRING_QUERY, Book.class);
        QUERY.setParameter("title", title);
        QUERY.setParameter("pk_isbn", book.getPk_isbn());
        return QUERY.executeUpdate();
    }

    @Override
    public int updateAuthor(Book book, Author author) {
        final String STRING_QUERY = "UPDATE Book b "
                + "SET b.fk_author = :fk_author "
                + "WHERE b.pk_isbn = :pk_isbn";
        final TypedQuery<Book> QUERY = this.entityManager.createQuery(STRING_QUERY, Book.class);
        QUERY.setParameter("fk_author", author.getPk_id());
        QUERY.setParameter("pk_isbn", book.getPk_isbn());
        return QUERY.executeUpdate();
    }
}