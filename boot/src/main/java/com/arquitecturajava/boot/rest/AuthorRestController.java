package com.arquitecturajava.boot.rest;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.services.LibraryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi/authors")
class AuthorRestController {

    @Autowired
    private LibraryService LIBRARY_SERVICE;
    
    @GetMapping("/{pk_id}")
    public Optional<Author> getAuthor(@PathVariable String pk_id) {
        return this.LIBRARY_SERVICE.selectAuthor(new Author(pk_id));
    }
    
    @GetMapping
    public List<Author> getAllAuthors() {
        return this.LIBRARY_SERVICE.selectAuthors();
    }
}