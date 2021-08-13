package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Author;
import java.util.List;

public interface AuthorRepository {
    
    Author select(Author author);
    
    List<Author> select();
    
    int insert(Author author);
    
    int delete(Author author);
    
    int update(Author author);
    
    int updatePk_id(Author auuthor, String pk_id);
    
    int updateName(Author auuthor, String name);
    
    int updateAge(Author auuthor, int age);
}