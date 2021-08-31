package com.arquitecturajava.boot.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cover")
public class Cover {
    
    @Id
    private int pk_cover;
    private String file_name;
    @OneToOne(mappedBy = "fk_cover")
    private Book book;

    public Cover() {
    }

    public Cover(int pk_cover) {
        this.pk_cover = pk_cover;
    }

    public Cover(String file_name) {
        this.file_name = file_name;
    }

    public Cover(int pk_cover, String file_name) {
        this.pk_cover = pk_cover;
        this.file_name = file_name;
    }

    public int getPk_cover() {
        return pk_cover;
    }

    public void setPk_cover(int pk_cover) {
        this.pk_cover = pk_cover;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.pk_cover;
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
        final Cover other = (Cover) obj;
        if (this.pk_cover != other.pk_cover) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.file_name;
    }
}