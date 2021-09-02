package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import com.arquitecturajava.boot.business.ChapterPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, ChapterPK> {
    
    List<Chapter> selectByBook(Book book);
    
    /*int delete(Book book);
    
    int updateChapter(Chapter oldChapter, Chapter newChapter);
    
    int updateTitle(Chapter chapter, String title);
    
    int updateBook(Chapter chapter, Book book);*/
}