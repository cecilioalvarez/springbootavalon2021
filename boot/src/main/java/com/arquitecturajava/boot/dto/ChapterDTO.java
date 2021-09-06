package com.arquitecturajava.boot.dto;

import com.arquitecturajava.boot.business.Chapter;
import java.util.Objects;

public class ChapterDTO {

    private String title;
    private int pages;
    private BookDTO book;

    public ChapterDTO() {
    }
    
    public ChapterDTO(Chapter chapter) {
        this.title = chapter.getPk_title();
        this.pages = chapter.getPages();
        this.book = new BookDTO(chapter.getPk_fk_book());
    }

    public ChapterDTO(String title, BookDTO book) {
        this.title = title;
        this.book = book;
    }

    public ChapterDTO(String title, int pages, BookDTO book) {
        this.title = title;
        this.pages = pages;
        this.book = book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.book);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChapterDTO other = (ChapterDTO) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.book.getTitle() + "] Capítulo: " + this.title + " [" + this.pages + " pags]";
    }
}