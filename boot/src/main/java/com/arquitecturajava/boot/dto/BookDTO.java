package com.arquitecturajava.boot.dto;

import com.arquitecturajava.boot.business.Book;
import java.util.Objects;

public class BookDTO {

    private String isbn;
    private String title;
    private AuthorDTO author;
    
    public BookDTO() {
    }
    
    public BookDTO(Book book) {
        this.isbn = book.getPk_isbn();
        this.title = book.getTitle();
        this.author = new AuthorDTO(book.getFk_author());
    }

    public BookDTO(String isbn) {
        this.isbn = isbn;
    }

    public BookDTO(String isbn, String title, AuthorDTO author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.isbn);
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
        final BookDTO other = (BookDTO) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.isbn + "] " + this.title + ", de " + this.author.getName() + ".";
    }
}