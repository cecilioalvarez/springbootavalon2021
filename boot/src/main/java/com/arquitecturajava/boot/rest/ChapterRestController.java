package com.arquitecturajava.boot.rest;

import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import com.arquitecturajava.boot.services.LibraryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi/books/{pk_isbn}/chapters")
public class ChapterRestController {

    @Autowired
    private LibraryService libraryService;
    
    @GetMapping
    public List<Chapter> getChapters(@PathVariable String pk_isbn) {
        return this.libraryService.selectChapters(this.libraryService.selectBook(new Book(pk_isbn)).get());
    }
}