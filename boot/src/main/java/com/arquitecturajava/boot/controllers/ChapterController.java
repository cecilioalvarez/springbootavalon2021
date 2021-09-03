package com.arquitecturajava.boot.controllers;

import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import com.arquitecturajava.boot.services.LibraryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/books/{pk_isbn}/chapters")
public class ChapterController {
    
    @Autowired
    private LibraryService libraryService;
    
    @RequestMapping("/list")
    public String getBookChaptersPage(Model model, @PathVariable String pk_isbn) {
        Optional<Book> optionalBook = this.libraryService.selectBook(new Book(pk_isbn));
        if (optionalBook.isPresent()) {
            final List<Chapter> CHAPTERS = this.libraryService.selectChapters(optionalBook.get());
            model.addAttribute("chapters", CHAPTERS);
            model.addAttribute("book", optionalBook.get());
        }
        return "bookChapters";
    }
    
    @RequestMapping("/add")
    public String getaddChapterPage(Model model, @PathVariable String pk_isbn) {
        Optional<Book> optionalBook = this.libraryService.selectBook(new Book(pk_isbn));
        if (optionalBook.isPresent()) {
            model.addAttribute("book", optionalBook.get());
        }
        return "addChapter";
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createChapterAction(Model model, Chapter chapter, @PathVariable String pk_isbn) {
        chapter.setPk_fk_book(new Book(pk_isbn));
        this.libraryService.insertChapter(chapter);
        return "redirect:list";
    }
    
    @RequestMapping("{pk_title}/delete")
    public String deleteChapterAction(Model model, @PathVariable String pk_isbn, @PathVariable String pk_title) {
        this.libraryService.deleteChapter(new Chapter(pk_title, new Book(pk_isbn)));
        return "redirect:../list";
    }
    
    @RequestMapping("{pk_title}/edit")
    public String getEditChapterPage(Model model, @PathVariable String pk_isbn, @PathVariable String pk_title) {
        Optional<Chapter> optionalChapter = this.libraryService.selectChapter(new Chapter(pk_title, new Book(pk_isbn)));
        if (optionalChapter.isPresent()) {
            model.addAttribute("chapter", optionalChapter.get());
        }
        return "editChapter";
    }
    
    @RequestMapping(value = "{pk_title}/update", method = RequestMethod.POST)
    public String updateChapterAction(Model model, Chapter chapter, String old_pk_title, @PathVariable String pk_isbn) {
        Book book = new Book(pk_isbn);
        chapter.setPk_fk_book(book);
        this.libraryService.updateChapter(chapter);
        return "redirect:../list";
    }
}