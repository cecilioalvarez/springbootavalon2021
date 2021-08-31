package com.arquitecturajava.boot.business;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

    @Id
    private String pk_isbn;
    private String title;
    @OneToOne
    @JoinColumn(name = "fk_cover", referencedColumnName = "pk_cover")
    private Cover fk_cover;
    @ManyToOne
    @JoinColumn(name = "fk_author", referencedColumnName = "pk_id")
    private Author fk_author;
    @OneToMany(mappedBy = "pk_fk_book")
    private List<Chapter> chapters;

    public Book() {
    }

    public Book(String pk_isbn) {
        this.pk_isbn = pk_isbn;
    }
    
    public Book(String pk_isbn, String title, Author author) {
        this.pk_isbn = pk_isbn;
        this.title = title;
        this.fk_author = author;
    }

    public Book(String pk_isbn, String title, Cover fk_cover, Author fk_author) {
        this.pk_isbn = pk_isbn;
        this.title = title;
        this.fk_cover = fk_cover;
        this.fk_author = fk_author;
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

    public Cover getFk_cover() {
        return fk_cover;
    }

    public void setFk_cover(Cover fk_cover) {
        this.fk_cover = fk_cover;
    }

    public Author getFk_author() {
        return this.fk_author;
    }

    public void setFk_author(Author fk_author) {
        this.fk_author = fk_author;
    }
    
    public void addChapter(Chapter chapter) {
        this.chapters.add(chapter);
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
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