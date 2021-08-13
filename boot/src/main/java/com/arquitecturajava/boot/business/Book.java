package com.arquitecturajava.boot.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {

    private String pk_isbn;
    private String title;
    private Author fk_author;
    private List<Chapter> chapters = new ArrayList<>();

    public Book() {
    }

    public Book(String pk_isbn) {
        this.pk_isbn = pk_isbn;
    }
    
    public Book(String isbn, String title, Author author) {
        this.pk_isbn = isbn;
        this.title = title;
        this.fk_author = author;
    }

    public Book(String isbn, String title, Author author, List<Chapter> chapters) {
        this.pk_isbn = isbn;
        this.title = title;
        this.fk_author = author;
        this.chapters = chapters;
    }

    public String getPk_isbn() {
        return this. pk_isbn;
    }

    public void setPk_isbn(String pk_isbn) {
        this.pk_isbn = pk_isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getFk_author() {
        return this.fk_author;
    }

    public void setFk_author(Author fk_author) {
        this.fk_author = fk_author;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }
    
    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.pk_isbn);
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
        final Book other = (Book) obj;
        if (!Objects.equals(this.pk_isbn, other.pk_isbn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.pk_isbn + "] " + this.title + ", de " + this.fk_author.getName() + ".";
    }
}