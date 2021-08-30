package com.arquitecturajava.boot;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@Sql({"/schema.sql", "/data.sql"})
class BootApplicationTests {
    
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void selectAuthorTest() {
        Author author = this.entityManager.find(Author.class, "00000000t");
        assertEquals(author.getPk_id(), "00000000t");
        assertEquals(author.getName(), "Anónimo");
        assertEquals(author.getAge(), 16);
    }
    
    @Test
    void selectAllAuthorsTest() {
        TypedQuery<Author> query = this.entityManager.createQuery("SELECT a FROM Author a", Author.class);
        List<Author> authors = query.getResultList();
        assertEquals(authors.size(), 10);
    }
    
    @Test
    void selectBooksByAuthorTest() {
        TypedQuery<Book> query = this.entityManager.createQuery("SELECT b FROM Book b WHERE b.fk_author.pk_id=:fk_author", Book.class);
        query.setParameter("fk_author", "11111111h");
        List<Book> books = query.getResultList();
        assertEquals(books.size(), 2);
    }
    
    @Test
    @Transactional
    void insertAuthorTest() {
        Author author1 = new Author("12345678z", "Autor de prueba", 25);
        this.entityManager.persist(author1);
        Author author2 = this.entityManager.find(Author.class, "12345678z");
        assertEquals(author2.getPk_id(), "12345678z");
        assertEquals(author2.getName(), "Autor de prueba");
        assertEquals(author2.getAge(), 25);
    }
    
    @Test
    @Transactional
    void deleteAuthorTest() {
        Author author = new Author("12345678z", "Autor de prueba", 25);
        this.entityManager.persist(author);
        author = this.entityManager.find(Author.class, "12345678z");
        this.entityManager.remove(author);
        author = this.entityManager.find(Author.class, "12345678z");
        assertNull(author);
    }
    
    @Test
    @Transactional
    void insertBookTest() {
        Author author = this.entityManager.find(Author.class, "11111111h");
        Book book = new Book("9998887776665", "Prueba de inserción", author);
        this.entityManager.persist(book);
        book = this.entityManager.find(Book.class, "9998887776665");
        assertEquals(book.getPk_isbn(), "9998887776665");
        assertEquals(book.getTitle(), "Prueba de inserción");
        assertEquals(book.getFk_author(), author);
    }
    
    @Test
    @Transactional
    void insertChapterTest() {
        Book book = this.entityManager.find(Book.class, "1234567890123");
        Chapter chapter = new Chapter("Primer capítulo", 10, book);
        this.entityManager.persist(chapter);
        chapter = this.entityManager.find(Chapter.class, chapter);
        assertEquals(chapter.getPk_title(), "Primer capítulo");
        assertEquals(chapter.getPages(), 10);
        assertEquals(chapter.getPk_fk_book().getTitle(), "Prueba");
    }
}