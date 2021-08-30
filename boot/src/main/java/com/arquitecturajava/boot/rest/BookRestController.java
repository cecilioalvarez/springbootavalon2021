package com.arquitecturajava.boot.rest;

import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.services.LibraryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi/books")
public class BookRestController {

    @Autowired
    private LibraryService LIBRARY_SERVICE;
    
    @GetMapping("/{pk_isbn}")
    public Book getBook(@PathVariable String pk_isbn) {
        return this.LIBRARY_SERVICE.selectBook(new Book(pk_isbn));
    }
    
    @GetMapping
    public List<Book> getAllBooks() {
        return this.LIBRARY_SERVICE.selectBooks();
    }
    
    @PostMapping
    public int insert(@RequestBody Book book) {
        return this.LIBRARY_SERVICE.insert(book);
    }
    
    @DeleteMapping("/{pk_isbn}")
    public int delete(@PathVariable String pk_isbn) {
        return this.LIBRARY_SERVICE.deleteBook(new Book(pk_isbn));
    }
    
    @PutMapping("/{pk_isbn}")
    public int update(@PathVariable String pk_isbn, @RequestBody Book book) {
        Book bookToUpdate = this.LIBRARY_SERVICE.selectBook(new Book(pk_isbn));
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setFk_author(book.getFk_author());
        //bookToUpdate.setChapters(book.getChapters());
        return this.LIBRARY_SERVICE.update(bookToUpdate);
    }
}