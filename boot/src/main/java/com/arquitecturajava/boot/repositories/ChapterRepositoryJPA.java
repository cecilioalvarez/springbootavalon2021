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
    private EntityManager entityManager;

    @Override
    public Chapter select(Chapter chapter) {
        return this.entityManager.find(Chapter.class, chapter);
    }

    @Override
    public List<Chapter> select() {
        return this.entityManager.createNamedQuery("Chapter.selectAll", Chapter.class).getResultList();
    }

    @Override
    public List<Chapter> select(Book book) {
        final TypedQuery<Chapter> QUERY = this.entityManager.createNamedQuery("Chapter.selectByBook", Chapter.class);
        QUERY.setParameter("pk_isbn", book.getPk_isbn());
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
        final String STRING_QUERY = "DELETE c "
                + "FROM Chapter c "
                + "WHERE c.pk_fk_book.pk_isbn = :pk_isbn";
        final TypedQuery<Book> QUERY = this.entityManager.createQuery(STRING_QUERY, Book.class);
        QUERY.setParameter("pk_isbn", book.getPk_isbn());
        return QUERY.executeUpdate();
    }

    @Override
    public int updateChapter(Chapter oldChapter, Chapter newChapter) {
        final String STRING_QUERY = "UPDATE Chapter c "
                + "SET c.pk_title = :new_pk_title "
                + "SET c.pages = :pages "
                + "WHERE c.pk_title = :old_pk_title "
                + "AND c.pk_fk_book.pk_isbn = :pk_isbn";
        final TypedQuery<Chapter> QUERY = this.entityManager.createQuery(STRING_QUERY, Chapter.class);
        QUERY.setParameter("new_pk_title", newChapter.getPk_title());
        QUERY.setParameter("pages", newChapter.getPages());
        QUERY.setParameter("old_pk_title", oldChapter.getPk_title());
        QUERY.setParameter("pk_isbn", oldChapter.getPk_fk_book().getPk_isbn());
        return QUERY.executeUpdate();
    }

    @Override
    public int updateTitle(Chapter chapter, String title) {
        final String STRING_QUERY = "UPDATE Chapter c "
                + "SET c.pk_title = :new_pk_title "
                + "WHERE c.pk_title = :old_pk_title "
                + "AND c.pk_fk_book.pk_isbn = :pk_isbn";
        final TypedQuery<Chapter> QUERY = this.entityManager.createQuery(STRING_QUERY, Chapter.class);
        QUERY.setParameter("new_pk_title", title);
        QUERY.setParameter("old_pk_title", chapter.getPk_title());
        QUERY.setParameter("pk_isbn", chapter.getPk_fk_book().getPk_isbn());
        return QUERY.executeUpdate();
    }

    @Override
    public int updatePages(Chapter chapter, int pages) {
        final String STRING_QUERY = "UPDATE Chapter c "
                + "SET c.pages = :pages "
                + "WHERE c.pk_title = :pk_title "
                + "AND c.pk_fk_book.pk_isbn = :pk_isbn";
        final TypedQuery<Chapter> QUERY = this.entityManager.createQuery(STRING_QUERY, Chapter.class);
        QUERY.setParameter("pages", pages);
        QUERY.setParameter("pk_title", chapter.getPk_title());
        QUERY.setParameter("pk_isbn", chapter.getPk_fk_book().getPk_isbn());
        return QUERY.executeUpdate();
    }

    @Override
    public int updateBook(Chapter chapter, Book book) {
        final String STRING_QUERY = "UPDATE Chapter c "
                + "SET c.pk_fk_book = :new_pk_fk_book "
                + "WHERE c.pk_title = :pk_title "
                + "AND c.pk_fk_book.pk_isbn = :old_pk_isbn";
        final TypedQuery<Chapter> QUERY = this.entityManager.createQuery(STRING_QUERY, Chapter.class);
        QUERY.setParameter("new_pk_fk_book", book.getPk_isbn());
        QUERY.setParameter("pk_title", chapter.getPk_title());
        QUERY.setParameter("old_pk_isbn", chapter.getPk_fk_book().getPk_isbn());
        return QUERY.executeUpdate();
    }
}