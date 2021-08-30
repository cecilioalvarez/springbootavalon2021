package com.arquitecturajava.boot.business;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="chapter")
public class Chapter implements Serializable {

    @Id
    private String pk_title;
    private int pages;
    @Id
    @ManyToOne
    @JoinColumn(name="pk_fk_book", referencedColumnName="pk_isbn")
    private Book pk_fk_book;
    
    public Chapter() {
    }

    public Chapter(String title, int pages, Book book) {
        this.pk_title = title;
        this.pages = pages;
        this.pk_fk_book = book;
    }
    
    public Chapter(String title, Book book) {
        this.pk_title = title;
        this.pk_fk_book = book;
    }

    public void setPk_title(String pk_title) {
        this.pk_title = pk_title;
    }
    
    public String getPk_title() {
        return this.pk_title;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPk_fk_book(Book pk_fk_book) {
        this.pk_fk_book = pk_fk_book;
    }

    public Book getPk_fk_book() {
        return this.pk_fk_book;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.pk_title);
        hash = 31 * hash + Objects.hashCode(this.pk_fk_book);
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
        final Chapter other = (Chapter) obj;
        if (!Objects.equals(this.pk_title, other.pk_title)) {
            return false;
        }
        if (!Objects.equals(this.pk_fk_book, other.pk_fk_book)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.pk_fk_book.getTitle() + "] Capítulo: " + this.pk_title + " [" + this.pages + " pags]";
    }
}