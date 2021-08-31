package com.arquitecturajava.boot.services;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import java.util.List;

public interface LibraryService {

    void deleteBook(Book book);

    int deleteBooks(Author fk_author);

    void insert(Book book);
    
    void insert(Book ...book);
    
    Book selectBook(Book book);

    Book selectBookWithChapters(Book book);
    
    List<Book> selectBooks();
    
    List<Book> selectBooksWithChapters();

    List<Book> selectBooks(Author fk_author);

    void update(Book book);

    int updateAuthor(Book book, Author author);

    int updatePk_isbn(Book book, String pk_isbn);

    int updateTitle(Book book, String title);
    
    Chapter select(Chapter chapter);
    
    List<Chapter> select();
    
    List<Chapter> select(Book book);
    
    void insert(Chapter chapter);
    
    void delete(Chapter chapter);
    
    int deleteChapters(Book book);
    
    void updateChapter(Chapter oldChapter, Chapter newChapter);
    
    void updateTitle(Chapter chapter, String title);
    
    void updatePages(Chapter chapter, int pages);
    
    void updateBook(Chapter chapter, Book book);
    
    Author select(Author author);
    
    List<Author> selectAuthors();
    
    void insert(Author author);
    
    void delete(Author author);
    
    void update(Author author);
    
    int updatePk_id(Author author, String pk_id);
    
    int updateName(Author author, String name);
    
    int updateAge(Author author, int age);
}