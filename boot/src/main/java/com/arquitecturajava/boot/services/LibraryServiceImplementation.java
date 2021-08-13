package com.arquitecturajava.boot.services;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import com.arquitecturajava.boot.repositories.AuthorRepository;
import com.arquitecturajava.boot.repositories.BookRepository;
import com.arquitecturajava.boot.repositories.ChapterRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryServiceImplementation implements LibraryService {
    
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ChapterRepository chapterRepository;
    @Autowired
    private AuthorRepository authorRepository;
    
    public Book selectBook(Book book) {
        return this.bookRepository.selectBook(book);
    }

    @Override
    public Book selectBookWithChapters(Book book) {
        return this.bookRepository.selectBookWithChapters(book);
    }

    @Override
    public List<Book> selectBooks() {
        return this.bookRepository.selectBooks();
    }

    @Override
    public List<Book> selectBooksWithChapters() {
        return this.bookRepository.selectBooksWithChapters();
    }

    @Override
    public List<Book> selectBooks(Author fk_author) {
        return this.bookRepository.select(fk_author);
    }
    
    @Transactional
    @Override
    public int insert(Book book) {
        return this.bookRepository.insert(book);
    }

    @Transactional
    @Override
    public int insert(Book... books) {
        int booksInserted = 0;
        for (Book book : books) {
            booksInserted += insert(book);
        }
        return booksInserted;
    }

    @Transactional
    @Override
    public int deleteBook(Book book) {
        return this.bookRepository.delete(book);
    }

    @Transactional
    @Override
    public int deleteBooks(Author fk_author) {
        return this.bookRepository.deleteBooks(fk_author);
    }

    @Transactional
    @Override
    public int update(Book book) {
        return this.bookRepository.update(book);
    }

    @Transactional
    @Override
    public int updatePk_isbn(Book book, String pk_isbn) {
        return this.bookRepository.updatePk_isbn(book, pk_isbn);
    }

    @Transactional
    @Override
    public int updateTitle(Book book, String title) {
        return this.bookRepository.updateTitle(book, title);
    }

    @Transactional
    @Override
    public int updateAuthor(Book book, Author author) {
        return this.bookRepository.updateAuthor(book, author);
    }

    @Override
    public Chapter select(Chapter chapter) {
        return this.chapterRepository.select(chapter);
    }

    @Override
    public List<Chapter> select() {
        return this.chapterRepository.select();
    }

    @Override
    public List<Chapter> select(Book book) {
        return this.chapterRepository.select(book);
    }

    @Transactional
    @Override
    public int insert(Chapter chapter) {
        return this.chapterRepository.insert(chapter);
    }

    @Transactional
    @Override
    public int delete(Chapter chapter) {
        return this.chapterRepository.delete(chapter);
    }

    @Transactional
    @Override
    public int deleteChapters(Book book) {
        return this.chapterRepository.delete(book);
    }

    @Transactional
    @Override
    public int updateChapter(Chapter oldChapter, Chapter newChapter) {
        return this.chapterRepository.updateChapter(oldChapter, newChapter);
    }

    @Transactional
    @Override
    public int updateTitle(Chapter chapter, String title) {
        return this.chapterRepository.updateTitle(chapter, title);
    }

    @Transactional
    @Override
    public int updatePages(Chapter chapter, int pages) {
        return this.chapterRepository.updatePages(chapter, pages);
    }

    @Transactional
    @Override
    public int updateBook(Chapter chapter, Book book) {
        return this.chapterRepository.updateBook(chapter, book);
    }

    @Override
    public Author select(Author author) {
        return this.authorRepository.select(author);
    }

    @Override
    public List<Author> selectAuthors() {
       return this.authorRepository.select();
    }

    @Transactional
    @Override
    public int insert(Author author) {
        return this.authorRepository.insert(author);
    }

    @Transactional
    @Override
    public int delete(Author author) {
        return this.authorRepository.delete(author);
    }

    @Transactional
    @Override
    public int update(Author author) {
        return this.authorRepository.update(author);
    }

    @Transactional
    @Override
    public int updatePk_id(Author author, String pk_id) {
        return this.authorRepository.updatePk_id(author, pk_id);
    }

    @Transactional
    @Override
    public int updateName(Author author, String name) {
        return this.authorRepository.updateName(author, name);
    }

    @Transactional
    @Override
    public int updateAge(Author author, int age) {
        return this.authorRepository.updateAge(author, age);
    }
}