package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Author;
import java.util.List;

public interface AuthorRepository {
    
    Author select(Author author);
    
    List<Author> select();
    
    void insert(Author author);
    
    void delete(Author author);
    
    void update(Author author);
    
    int updatePk_id(Author author, String pk_id);
    
    int updateName(Author author, String name);
    
    int updateAge(Author author, int age);
}