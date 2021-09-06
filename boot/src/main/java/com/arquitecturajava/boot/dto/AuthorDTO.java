package com.arquitecturajava.boot.dto;

import com.arquitecturajava.boot.business.Author;
import java.util.Objects;

public class AuthorDTO {

    private String id;
    private String name;
    private int age;

    public AuthorDTO() {
    }

    public AuthorDTO(String id) {
        this.id = id;
    }

    public AuthorDTO(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public AuthorDTO(Author author) {
        this.id = author.getPk_id();
        this.name = author.getName();
        this.age = author.getAge();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final AuthorDTO other = (AuthorDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.id + "] " + this.name + " tiene " + this.age + " años.";
    }
}