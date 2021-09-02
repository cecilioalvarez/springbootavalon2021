package com.arquitecturajava.boot.services;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import com.arquitecturajava.boot.repositories.AuthorRepository;
import com.arquitecturajava.boot.repositories.BookRepository;
import com.arquitecturajava.boot.repositories.ChapterRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryServiceImplementation implements LibraryService {
    
    @Autowired
    @Qualifier("jpa")
    private BookRepository bookRepository;
    @Autowired
    @Qualifier("jpa")
    private ChapterRepository chapterRepository;
    @Autowired
    @Qualifier("jpa")
    private AuthorRepository authorRepository;
    
    public Optional<Book> selectBook(Book book) {
        return this.bookRepository.select(book);
    }

    @Override
    public Book selectBookWithChapters(Book book) {
        return this.bookRepository.selectAllWithChapters(book);
    }

    @Override
    public List<Book> selectBooks() {
        return this.bookRepository.selectAll();
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
    public void insert(Book book) {
        this.bookRepository.insert(book);
    }

    @Transactional
    @Override
    public void insert(Book... books) {
        Arrays.asList(books).forEach(book -> this.bookRepository.insert(book));
    }

    @Transactional
    @Override
    public void deleteBook(Book book) {
        this.bookRepository.delete(book);
    }

    @Transactional
    @Override
    public int deleteBooks(Author fk_author) {
        return this.bookRepository.deleteBooks(fk_author);
    }

    @Transactional
    @Override
    public void update(Book book) {
        this.bookRepository.update(book);
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
    public Optional<Chapter> select(Chapter chapter) {
        return this.chapterRepository.select(chapter);
    }

    @Override
    public List<Chapter> select() {
        return this.chapterRepository.selectAll();
    }

    @Override
    public List<Chapter> select(Book book) {
        return this.chapterRepository.select(book);
    }

    @Transactional
    @Override
    public void insert(Chapter chapter) {
        this.chapterRepository.insert(chapter);
    }

    @Transactional
    @Override
    public void delete(Chapter chapter) {
        this.chapterRepository.delete(chapter);
    }

    @Transactional
    @Override
    public int deleteChapters(Book book) {
        return this.chapterRepository.delete(book);
    }

    @Transactional
    @Override
    public void updateChapter(Chapter oldChapter, Chapter newChapter) {
        this.chapterRepository.updateChapter(oldChapter, newChapter);
    }

    @Transactional
    @Override
    public void updateTitle(Chapter chapter, String title) {
        this.chapterRepository.updateTitle(chapter, title);
    }

    @Transactional
    @Override
    public void updateBook(Chapter chapter, Book book) {
        this.chapterRepository.updateBook(chapter, book);
    }

    @Override
    public Optional<Author> select(Author author) {
        return this.authorRepository.select(author);
    }

    @Override
    public List<Author> selectAuthors() {
       return this.authorRepository.selectAll();
    }

    @Transactional
    @Override
    public void insert(Author author) {
        this.authorRepository.insert(author);
    }

    @Transactional
    @Override
    public void delete(Author author) {
        this.authorRepository.delete(author);
    }

    @Transactional
    @Override
    public void update(Author author) {
        this.authorRepository.update(author);
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