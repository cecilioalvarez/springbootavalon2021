package com.arquitecturajava.boot.services;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import java.util.List;
import java.util.Optional;

public interface LibraryService {

    void deleteBook(Book book);

    int deleteBooks(Author fk_author);

    void insert(Book book);
    
    void insert(Book ...book);
    
    Optional<Book> selectBook(Book book);

    Book selectBookWithChapters(Book book);
    
    List<Book> selectBooks();
    
    List<Book> selectAllWithChapters();

    List<Book> selectBooks(Author fk_author);

    void update(Book book);

    /*int updateAuthor(Book book, Author author);

    int updatePk_isbn(Book book, String pk_isbn);

    int updateTitle(Book book, String title);*/
    
    Optional<Chapter> selectChapter(Chapter chapter);
    
    List<Chapter> selectChapters();
    
    List<Chapter> selectChapters(Book book);
    
    void insert(Chapter chapter);
    
    void delete(Chapter chapter);
    
    /*int deleteChapters(Book book);
    
    void updateChapter(Chapter oldChapter, Chapter newChapter);*/
    
    void updateChapter(Chapter chapter);
    
    /*void updateTitle(Chapter chapter, String title);
    
    void updateBook(Chapter chapter, Book book);*/
    
    Optional<Author> selectAuthor(Author author);
    
    List<Author> selectAuthors();
    
    void insert(Author author);
    
    void delete(Author author);
    
    void update(Author author);
    
    /*int updatePk_id(Author author, String pk_id);
    
    int updateName(Author author, String name);
    
    int updateAge(Author author, int age);*/
}