package com.arquitecturajava.boot;

import com.arquitecturajava.boot.business.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@Sql({"/schema.sql", "/data.sql"})
class BootApplicationTests2 {
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Test
    void selectAllAuthorsTest() {
        TypedQuery<Book> query = this.entityManager.createQuery("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.chapters", Book.class);
        List<Book> books = query.getResultList();
        books.forEach(book -> {
            System.out.println(book);
            book.getChapters().forEach(chapter -> System.out.println(chapter));
        });
    }
}