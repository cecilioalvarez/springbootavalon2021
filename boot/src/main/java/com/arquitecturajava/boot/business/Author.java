package com.arquitecturajava.boot.business;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "author")
@NamedQuery(name = "Author.selectAll", query = "SELECT a FROM Author a")
public class Author implements Serializable {

    @Id
    private String pk_id;
    private String name;
    private int age;
    @OneToMany(mappedBy = "fk_author")
    private List<Book> books;
    
    public Author() {
    }

    public Author(String id, String name, int age) {
        this.pk_id = id;
        this.name = name;
        this.age = age;
    }

    public Author(String pk_id) {
        this.pk_id = pk_id;
    }

    public String getPk_id() {
        return this.pk_id;
    }

    public void setPk_id(String pk_id) {
        this.pk_id = pk_id;
    }

    public String getName() {
        return this.name;
    }

   public  void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.pk_id);
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
        final Author other = (Author) obj;
        if (!Objects.equals(this.pk_id, other.pk_id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + this.pk_id + "] " + this.name + " tiene " + this.age + " años.";
    }
}