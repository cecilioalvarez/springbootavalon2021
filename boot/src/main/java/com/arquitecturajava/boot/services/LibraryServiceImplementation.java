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
    
    @Override
    public Optional<Book> selectBook(Book book) {
        return this.bookRepository.findById(book.getPk_isbn());
    }

    @Override
    public Book selectBookWithChapters(Book book) {
        return this.bookRepository.selectBookWithChapters(book);
    }

    @Override
    public List<Book> selectBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> selectAllWithChapters() {
        return this.bookRepository.selectAllWithChapters();
    }

    @Override
    public List<Book> selectBooks(Author fk_author) {
        return this.bookRepository.selectAllByAuthor(fk_author);
    }
    
    @Transactional
    @Override
    public void insertBook(Book book) {
        this.bookRepository.save(book);
    }

    @Transactional
    @Override
    public void insertBook(Book... books) {
        Arrays.asList(books).forEach(book -> this.bookRepository.save(book));
    }

    @Transactional
    @Override
    public void deleteBook(Book book) {
        this.bookRepository.delete(book);
    }

    @Transactional
    @Override
    public int deleteBooks(Author fk_author) {
        return this.bookRepository.deleteBooksByAuthor(fk_author);
    }

    @Transactional
    @Override
    public void updateBook(Book book) {
        this.bookRepository.save(book);
    }

    /*@Transactional
    @Override
    public int updatePk_isbn(Book book, String pk_isbn) {
        return this.bookRepository.updateIsbn(book, pk_isbn);
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
    }*/

    @Override
    public Optional<Chapter> selectChapter(Chapter chapter) {
        return this.chapterRepository.findById(chapter.getPk_chapter());
    }

    @Override
    public List<Chapter> selectChapters() {
        return this.chapterRepository.findAll();
    }

    @Override
    public List<Chapter> selectChapters(Book book) {
        return this.chapterRepository.selectByBook(book);
    }

    @Transactional
    @Override
    public void insertChapter(Chapter chapter) {
        this.chapterRepository.save(chapter);
    }

    @Transactional
    @Override
    public void deleteChapter(Chapter chapter) {
        this.chapterRepository.delete(chapter);
    }

    @Transactional
    @Override
    public int deleteChapters(Book book) {
        return this.chapterRepository.deleteByBook(book);
    }
    

    @Override
    public void updateChapter(Chapter chapter) {
        this.chapterRepository.save(chapter);
    }

    /*@Transactional
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
    }*/

    @Override
    public Optional<Author> selectAuthor(Author author) {
        return this.authorRepository.findById(author.getPk_id());
    }

    @Override
    public List<Author> selectAuthors() {
       return this.authorRepository.findAll();
    }

    @Transactional
    @Override
    public void insertAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Transactional
    @Override
    public void deleteAuthor(Author author) {
        this.authorRepository.delete(author);
    }

    @Transactional
    @Override
    public void updateAuthor(Author author) {
        this.authorRepository.save(author);
    }

   /* @Transactional
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
    }*/
}