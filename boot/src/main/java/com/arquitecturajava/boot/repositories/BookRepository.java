package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import java.util.List;

public interface BookRepository extends GenericRepository<Book> {
    
    Book selectAllWithChapters(Book book);
    
    List<Book> selectBooksWithChapters();
    
    List<Book> select(Author fk_author);
    
    int deleteBooks(Author fk_author);
    
    int updatePk_isbn(Book book, String pk_isbn);
    
    int updateTitle(Book book, String title);
    
    int updateAuthor(Book book, Author author);
}