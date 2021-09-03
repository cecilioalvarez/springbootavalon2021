package com.arquitecturajava.boot.business;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "chapter")
@NamedQuery(name = "Chapter.selectByBook", query = "SELECT c FROM Chapter c WHERE c.pk_chapter.pk_fk_book = :book")
@NamedQuery(name = "Chapter.deleteByBook", query = "DELETE FROM Chapter c WHERE c.pk_chapter.pk_fk_book = :book")
public class Chapter implements Serializable {

    @EmbeddedId
    private ChapterPK pk_chapter;
    private int pages;
    
    public Chapter() {
    }

    public Chapter(String title, int pages, Book book) {
        this.pk_chapter = new ChapterPK(title, book);
        this.pages = pages;
    }
    
    public Chapter(String title, Book book) {
        this.pk_chapter = new ChapterPK(title, book);
    }

    public void setPk_title(String pk_title) {
        this.pk_chapter = new ChapterPK();
        this.pk_chapter.setPk_title(pk_title);
    }
    
    public String getPk_title() {
        return this.pk_chapter.getPk_title();
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPk_fk_book(Book pk_fk_book) {
        this.pk_chapter.setPk_fk_book(pk_fk_book);
    }

    public Book getPk_fk_book() {
        return this.pk_chapter.getPk_fk_book();
    }

    public ChapterPK getPk_chapter() {
        return pk_chapter;
    }

    public void setPk_chapter(ChapterPK pk_chapter) {
        this.pk_chapter = pk_chapter;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.pk_chapter);
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
        if (!Objects.equals(this.pk_chapter, other.pk_chapter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.pk_chapter.getPk_fk_book().getTitle() + "] Capítulo: " + this.pk_chapter.getPk_title() + " [" + this.pages + " pags]";
    }
}