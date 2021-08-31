package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import java.util.List;

public interface BookRepository {
    
    Book selectBook(Book book);
    
    Book selectBookWithChapters(Book book);
    
    List<Book> selectBooks();
    
    List<Book> selectBooksWithChapters();
    
    List<Book> select(Author fk_author);
    
    void insert(Book book);
    
    void delete(Book book);
    
    int deleteBooks(Author fk_author);
    
    void update(Book book);
    
    int updatePk_isbn(Book book, String pk_isbn);
    
    int updateTitle(Book book, String title);
    
    int updateAuthor(Book book, Author author);
}