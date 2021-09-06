package com.arquitecturajava.boot.rest;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.dto.AuthorDTO;
import com.arquitecturajava.boot.services.LibraryService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
    public Optional<AuthorDTO> getAuthor(@PathVariable String pk_id) {
        Optional<Author> oAuthor = this.LIBRARY_SERVICE.selectAuthor(new Author(pk_id));
        return oAuthor.isPresent() ? Optional.of(new AuthorDTO(oAuthor.get())) : Optional.empty();
    }
    
    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return this.LIBRARY_SERVICE.selectAuthors().stream().map(AuthorDTO::new).collect(Collectors.toList());
    }
}