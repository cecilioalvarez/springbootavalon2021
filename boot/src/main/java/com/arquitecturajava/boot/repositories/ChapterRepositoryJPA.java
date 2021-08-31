package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public class ChapterRepositoryJPA implements ChapterRepository {
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Chapter select(Chapter chapter) {
        return this.entityManager.find(Chapter.class, chapter);
    }

    @Override
    public List<Chapter> select() {
        final String QUERY = "SELECT c "
                + "FROM Chapter c";
        return this.entityManager.createQuery(QUERY, Chapter.class).getResultList();
    }

    @Override
    public List<Chapter> select(Book book) {
        final String STRING_QUERY = "SELECT c "
                + "FROM Chapter c "
                + "WHERE c.pk_fk_book = :pk_fk_book";
        final TypedQuery<Chapter> QUERY = this.entityManager.createQuery(STRING_QUERY, Chapter.class);
        QUERY.setParameter("pk_fk_book", book.getPk_isbn());
        return QUERY.getResultList();
    }

    @Override
    public void insert(Chapter chapter) {
        this.entityManager.persist(chapter);
    }

    @Override
    public void delete(Chapter chapter) {
        this.entityManager.remove(this.entityManager.merge(chapter));
    }

    @Override
    public int delete(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateChapter(Chapter oldChapter, Chapter newChapter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateTitle(Chapter chapter, String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updatePages(Chapter chapter, int pages) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBook(Chapter chapter, Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}