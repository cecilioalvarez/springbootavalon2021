package com.arquitecturajava.boot.repositories;

import com.arquitecturajava.boot.business.Author;

public interface AuthorRepository extends GenericRepository<Author> {
    
    int updatePk_id(Author author, String pk_id);
    
    int updateName(Author author, String name);
    
    int updateAge(Author author, int age);
}