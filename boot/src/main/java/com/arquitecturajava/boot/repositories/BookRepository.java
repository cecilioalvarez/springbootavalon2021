package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
    
    Book selectBookWithChapters(Book book);
    
    List<Book> selectAllWithChapters();
    
    List<Book> selectAllByAuthor(Author fk_author);
    
    int deleteBooksByAuthor(Author fk_author);
    
    /*int updateIsbn(Book book, String pk_isbn);
    
    int updateTitle(Book book, String title);
    
    int updateAuthor(Book book, Author author);*/
}