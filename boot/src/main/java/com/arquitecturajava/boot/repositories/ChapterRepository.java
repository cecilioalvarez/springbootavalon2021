package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Book;
import com.arquitecturajava.boot.business.Chapter;
import java.util.List;

public interface ChapterRepository {
    
    Chapter select(Chapter chapter);
    
    List<Chapter> select();
    
    List<Chapter> select(Book book);
    
    void insert(Chapter chapter);
    
    void delete(Chapter chapter);
    
    int delete(Book book);
    
    void updateChapter(Chapter oldChapter, Chapter newChapter);
    
    void updateTitle(Chapter chapter, String title);
    
    void updatePages(Chapter chapter, int pages);
    
    void updateBook(Chapter chapter, Book book);
}