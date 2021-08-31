package com.arquitecturajava.boot.controllers;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books")
public class BookController {
    
    @Autowired
    private LibraryService libraryService;
    
    @RequestMapping("/list")
    public String getBookListPage(Model model) {
        model.addAttribute("books", this.libraryService.selectBooks());
        return "bookList";
    }
    
    @RequestMapping("/list/{pk_id}")
    public String getAuthorBookListPage(Model model, @PathVariable String pk_id) {
        Author author = this.libraryService.select(new Author(pk_id));
        model.addAttribute("books", this.libraryService.selectBooks(author));
        model.addAttribute("author", author);
        return "bookList";
    }
    
    @RequestMapping("/add")
    public String getAddBookPage(Model model) {
        model.addAttribute("authors", this.libraryService.selectAuthors());
        return "addBook";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBookAction(Model model, Book book) {
        this.libraryService.insert(book);
        return "redirect:/books/list";
    }
    
    @RequestMapping("/delete")
    public String deteleBookAction(Model model, Book book) {
        this.libraryService.deleteBook(book);
        return "redirect:/books/list";
    }
    
    @RequestMapping("/{pk_isbn}/edit")
    public String getEditBookPage(Model model, @PathVariable String pk_isbn) {
        model.addAttribute("book", this.libraryService.selectBook(new Book(pk_isbn)));
        model.addAttribute("authors", this.libraryService.selectAuthors());
        return "editBook";
    }
    
    @RequestMapping("/{pk_isbn}/update")
    public String updateBookAction(Model model, Book book) {
        this.libraryService.update(book);
        return "redirect:/books/list";
    }
}