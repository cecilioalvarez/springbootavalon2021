package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import com.arquitecturajava.boot.mappers.ChapterMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Qualifier("jdbc")
public class ChapterRepositoryJDBC implements ChapterRepository {
    
    @Autowired
    private JdbcTemplate template;

    @Override
    public Chapter select(Object chapter_object) {
        final String QUERY = "SELECT * FROM chapter c "
                + "INNER JOIN book b ON c.pk_fk_book = b.pk_isbn "
                + "INNER JOIN author a ON b.fk_author = a.pk_id "
                + "WHERE c.pk_title = ? AND b.pk_isbn = ?";
        Chapter chapter = (Chapter) chapter_object;
        Object[] params = {chapter.getPk_title(), chapter.getPk_fk_book().getPk_isbn()};
        return this.template.queryForObject(QUERY, params, new ChapterMapper());
    }

    @Override
    public List<Chapter> select(Book book) {
        final String QUERY = "SELECT * FROM chapter c "
                + "INNER JOIN book b ON c.pk_fk_book = b.pk_isbn "
                + "INNER JOIN author a ON b.fk_author = a.pk_id "
                + "WHERE b.pk_isbn = ?";
        Object[] params = {book.getPk_isbn()};
        return this.template.query(QUERY, params, new ChapterMapper());
    }

    @Override
    public List<Chapter> selectAll() {
        final String QUERY = "SELECT * FROM chapter c "
                + "INNER JOIN book b ON c.pk_fk_book = b.pk_isbn "
                + "INNER JOIN author a ON b.fk_author = a.pk_id";
        return this.template.query(QUERY, new ChapterMapper());
    }

    @Transactional
    @Override
    public void insert(Chapter chapter) {
        final String QUERY = "INSERT INTO chapter (pk_title, pages, pk_fk_book) VALUES (?, ?, ?)";
        this.template.update(QUERY, chapter.getPk_title(), chapter.getPages(), chapter.getPk_fk_book().getPk_isbn());
    }

    @Transactional
    @Override
    public void delete(Chapter chapter) {
        final String QUERY = "DELETE FROM chapter WHERE pk_title = ? AND pk_fk_book = ?";
        this.template.update(QUERY, chapter.getPk_title(), chapter.getPk_fk_book().getPk_isbn());
    }

    @Transactional
    @Override
    public int delete(Book book) {
        final String QUERY = "DELETE FROM chapter WHERE pk_fk_book = ?";
        return this.template.update(QUERY, book.getPk_isbn());
    }

    @Transactional
    @Override
    public void update(Chapter entity) {
        final String QUERY = "UPDATE chapter SET pages = ? WHERE pk_title = ? AND pk_fk_book = ?";
        this.template.update(QUERY, entity.getPages(), entity.getPk_title(), entity.getPk_fk_book().getPk_isbn());
    }

    @Transactional
    @Override
    public int updateChapter(Chapter oldChapter, Chapter newChapter) {
        final String QUERY = "UPDATE chapter SET pk_title = ?, pages = ? WHERE pk_title = ? AND pk_fk_book = ?";
        return this.template.update(QUERY, newChapter.getPk_title(), newChapter.getPages(), 
                oldChapter.getPk_title(), oldChapter.getPk_fk_book().getPk_isbn());
    }

    @Transactional
    @Override
    public int updateTitle(Chapter chapter, String title) {
        final String QUERY = "UPDATE chapter SET pk_title = ? WHERE pk_title = ? AND pk_fk_book = ?";
        return this.template.update(QUERY, title, chapter.getPk_title(), chapter.getPk_fk_book().getPk_isbn());
    }

    @Transactional
    @Override
    public int updateBook(Chapter chapter, Book book) {
        final String QUERY = "UPDATE chapter SET pk_fk_book = ? WHERE pk_title = ? AND pk_fk_book = ?";
        return this.template.update(QUERY, book.getPk_isbn(), chapter.getPk_title(), chapter.getPk_fk_book().getPk_isbn());
    }
}