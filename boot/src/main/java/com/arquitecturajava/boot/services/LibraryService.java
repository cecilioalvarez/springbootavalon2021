package com.arquitecturajava.boot.services;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import java.util.List;

public interface LibraryService {

    int deleteBook(Book book);

    int deleteBooks(Author fk_author);

    int insert(Book book);
    
    int insert(Book ...book);
    
    Book selectBook(Book book);

    Book selectBookWithChapters(Book book);
    
    List<Book> selectBooks();
    
    List<Book> selectBooksWithChapters();

    List<Book> selectBooks(Author fk_author);

    int update(Book book);

    int updateAuthor(Book book, Author author);

    int updatePk_isbn(Book book, String pk_isbn);

    int updateTitle(Book book, String title);
    
    Chapter select(Chapter chapter);
    
    List<Chapter> select();
    
    List<Chapter> select(Book book);
    
    int insert(Chapter chapter);
    
    int delete(Chapter chapter);
    
    int deleteChapters(Book book);
    
    int updateChapter(Chapter oldChapter, Chapter newChapter);
    
    int updateTitle(Chapter chapter, String title);
    
    int updatePages(Chapter chapter, int pages);
    
    int updateBook(Chapter chapter, Book book);
    
    Author select(Author author);
    
    List<Author> selectAuthors();
    
    int insert(Author author);
    
    int delete(Author author);
    
    int update(Author author);
    
    int updatePk_id(Author author, String pk_id);
    
    int updateName(Author author, String name);
    
    int updateAge(Author author, int age);
}