package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import java.util.List;

public interface ChapterRepository extends GenericRepository<Chapter> {
    
    List<Chapter> select(Book book);
    
    int delete(Book book);
    
    int updateChapter(Chapter oldChapter, Chapter newChapter);
    
    int updateTitle(Chapter chapter, String title);
    
    int updateBook(Chapter chapter, Book book);
}