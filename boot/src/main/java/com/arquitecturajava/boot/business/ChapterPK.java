package com.arquitecturajava.boot.business;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ChapterPK implements Serializable {
    
    private String pk_title;
    @ManyToOne
    @JoinColumn(name = "pk_fk_book", referencedColumnName = "pk_isbn")
    private Book pk_fk_book;
    
    public ChapterPK() {
    }

    public ChapterPK(String pk_title, Book pk_fk_book) {
        this.pk_title = pk_title;
        this.pk_fk_book = pk_fk_book;
    }

    public String getPk_title() {
        return pk_title;
    }

    public void setPk_title(String pk_title) {
        this.pk_title = pk_title;
    }

    public Book getPk_fk_book() {
        return pk_fk_book;
    }

    public void setPk_fk_book(Book pk_fk_book) {
        this.pk_fk_book = pk_fk_book;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.pk_title);
        hash = 59 * hash + Objects.hashCode(this.pk_fk_book);
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
        final ChapterPK other = (ChapterPK) obj;
        if (!Objects.equals(this.pk_title, other.pk_title)) {
            return false;
        }
        if (!Objects.equals(this.pk_fk_book, other.pk_fk_book)) {
            return false;
        }
        return true;
    }
}