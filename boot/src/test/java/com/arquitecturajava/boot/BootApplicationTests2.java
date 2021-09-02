package com.arquitecturajava.boot;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@Sql({"/schema.sql", "/data.sql"})
class BootApplicationTests2 {
    
    @PersistenceContext
    EntityManager entityManager;
    
    /*@Test
    void selectAllBooksWithChaptersTest() {
        final String QUERY = "SELECT DISTINCT b "
                + "FROM Book b "
                + "LEFT JOIN FETCH b.fk_author "
                + "LEFT JOIN FETCH b.chapters";
        TypedQuery<Book> query = this.entityManager.createQuery(QUERY, Book.class);
        List<Book> books = query.getResultList();
        books.forEach(book -> book.getChapters().forEach(chapter -> System.out.println(chapter)));
    }
    
    @Test 
    void selectAllBooksWithCoverTest() {
        final String QUERY = "SELECT DISTINCT b "
                + "FROM Book b "
                + "LEFT JOIN FETCH b.fk_author "
                + "LEFT JOIN FETCH b.fk_cover";
        TypedQuery<Book> query = this.entityManager.createQuery(QUERY, Book.class);
        List<Book> books = query.getResultList();
        books.forEach(book -> System.out.println(book.getFk_cover()));
    }*/
}