package com.arquitecturajava.boot.controllers;

import com.arquitecturajava.boot.business.Author;
import com.arquitecturajava.boot.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private LibraryService LIBRARY_SERVICE;
    
    @RequestMapping("/{pk_id}")
    public String getAuthorDetailPage(Model model, @PathVariable String pk_id) {
        model.addAttribute("author", this.LIBRARY_SERVICE.select(new Author(pk_id)));
        return "authorDetail";
    }
}